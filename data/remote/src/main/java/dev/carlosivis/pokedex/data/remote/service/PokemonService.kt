package dev.carlosivis.pokedex.data.remote.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("/pokemon?limit=100000&offset=0")
    suspend fun getAll(): ResponseBody

    @GET("/pokemon/")
    suspend fun getPokemon(
        @Query("id") id: Int
    ): ResponseBody
}