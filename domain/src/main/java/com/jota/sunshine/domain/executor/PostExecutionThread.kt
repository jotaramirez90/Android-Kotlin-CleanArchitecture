package com.jota.sunshine.domain.executor

import rx.Scheduler

interface PostExecutionThread {
    val scheduler: Scheduler
}