package com.jota.sunshine.domain.exception

interface ErrorBundle {
    val exception: Exception

    val errorMessage: String
}