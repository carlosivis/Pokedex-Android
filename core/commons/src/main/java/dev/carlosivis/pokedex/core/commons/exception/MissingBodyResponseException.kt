package dev.carlosivis.pokedex.core.commons.exception

class MissingBodyResponseException(
    override val message: String? = null
) : Throwable(message)