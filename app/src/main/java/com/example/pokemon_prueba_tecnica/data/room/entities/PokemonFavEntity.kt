package com.example.pokemon_prueba_tecnica.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_favs")
data class PokemonFavEntity(
    @PrimaryKey val pokemonId: String = "",
    val name: String = "",
    val spriteUrl: String = ""
)