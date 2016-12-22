package com.jota.sunshine

import com.jota.sunshine.domain.executor.PostExecutionThread
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UIThread @Inject constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}
