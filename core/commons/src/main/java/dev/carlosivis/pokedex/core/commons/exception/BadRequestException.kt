package dev.carlosivis.pokedex.core.commons.exception

class BadRequestException(
    override val message: String? = null
) : Throwable(message)