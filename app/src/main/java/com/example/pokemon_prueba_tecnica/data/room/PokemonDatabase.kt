package com.example.pokemon_prueba_tecnica.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pokemon_prueba_tecnica.data.room.dao.PokemonRoomDao
import com.example.pokemon_prueba_tecnica.data.room.dao.SavedPokemonDao
import com.example.pokemon_prueba_tecnica.data.room.entities.PokemonFavEntity
import com.example.pokemon_prueba_tecnica.data.room.entities.SavedPokemonEntity

@Database(
    entities = [PokemonFavEntity::class, SavedPokemonEntity::class],
    version = 1,
    exportSchema = false
)

abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonRoomDao
    abstract fun savedPokemonDao(): SavedPokemonDao

}
