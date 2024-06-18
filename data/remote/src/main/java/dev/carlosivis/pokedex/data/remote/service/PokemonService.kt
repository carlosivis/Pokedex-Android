package dev.carlosivis.pokedex.data.remote.service

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("/api/v2/pokemon?limit=50&offset=0")
    suspend fun getAll(): ResponseBody

    @GET("/api/v2/pokemon")
    suspend fun getPages(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ResponseBody

    @GET("/pokemon/")
    suspend fun getPokemon(
        @Query("id") id: Int
    ): ResponseBody
}