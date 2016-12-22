package com.jota.sunshine.domain.exception

class DefaultErrorBundle(override val exception: Exception) : ErrorBundle {

    override val errorMessage: String
        get() = this.exception.message!!

}
