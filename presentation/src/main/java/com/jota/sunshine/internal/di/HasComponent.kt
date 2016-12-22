package com.jota.sunshine.internal.di

interface HasComponent<C> {
    fun getComponent(): C
}