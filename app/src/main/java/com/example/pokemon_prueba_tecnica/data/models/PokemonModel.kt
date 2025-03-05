package com.example.pokemon_prueba_tecnica.data.models

data class PokemonModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<PokemonResults>
)

data class PokemonResults(
    val name: String,
    val url: String
)

