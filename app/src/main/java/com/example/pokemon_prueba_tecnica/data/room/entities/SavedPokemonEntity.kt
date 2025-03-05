package com.example.pokemon_prueba_tecnica.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_pokemon")
data class SavedPokemonEntity(
    @PrimaryKey val id: String,
    val name: String = "",
    val imageUrl: String = ""

)


