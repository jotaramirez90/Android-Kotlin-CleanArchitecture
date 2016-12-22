package com.jota.sunshine.domain.interactors

import com.jota.sunshine.domain.executor.PostExecutionThread
import com.jota.sunshine.domain.executor.ThreadExecutor
import rx.Observable
import rx.Subscriber
import rx.functions.Action0
import rx.functions.Action1
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

abstract class UseCase<T> protected constructor(private val threadExecutor: ThreadExecutor,
                                                private val postExecutionThread: PostExecutionThread) {

    private var subscription = Subscriptions.empty()

    protected abstract fun buildUseCaseObservable(): Observable<T>

    @SuppressWarnings("unchecked")
    fun execute(useCaseSubscriber: Subscriber<T>) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(useCaseSubscriber)
    }

    @SuppressWarnings("unchecked")
    fun execute(onNext: Action1<T>, onError: Action1<Throwable>) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(onNext, onError)
    }

    @SuppressWarnings("unchecked")
    fun execute(onNext: Action1<T>, onError: Action1<Throwable>, onCompleted: Action0) {
        this.subscription = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
                .subscribe(onNext, onError, onCompleted)
    }

    fun unsubscribe() {
        if (!subscription.isUnsubscribed) {
            subscription.unsubscribe()
        }
    }
}
