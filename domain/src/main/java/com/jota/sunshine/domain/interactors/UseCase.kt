package com.jota.sunshine.domain.interactors

import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import dagger.internal.Preconditions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers


abstract class UseCase<T, Params> internal constructor(private val threadExecutor: ThreadExecutor,
                                                       private val postExecutionThread: PostExecutionThread) {
    private val disposables: CompositeDisposable

    init {
        this.disposables = CompositeDisposable()
    }

    internal abstract fun buildUseCaseObservable(params: Params): Observable<T>

    fun execute(observer: DisposableObserver<T>, params: Params) {
        Preconditions.checkNotNull(observer)
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose()
        }
    }

    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}
