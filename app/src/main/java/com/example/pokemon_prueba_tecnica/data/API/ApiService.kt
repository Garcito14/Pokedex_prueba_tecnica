package com.example.pokemon_prueba_tecnica.data.API

import com.example.pokemon_prueba_tecnica.data.models.PokemonDetailModel
import com.example.pokemon_prueba_tecnica.data.models.PokemonModel
import com.example.pokemon_prueba_tecnica.data.models.PokemonSpeciesModel
import com.example.pokemon_prueba_tecnica.ui.utils.Constants.URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface   ApiService {

    @GET(URL)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonModel>




    @GET("pokemon/{pokemonId}")
    suspend fun getPokemonDetail(
        @Path("pokemonId") pokemonId: String
    ): Response<PokemonDetailModel>



    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpecies(@Path("id") id: String): Response<PokemonSpeciesModel>
}


