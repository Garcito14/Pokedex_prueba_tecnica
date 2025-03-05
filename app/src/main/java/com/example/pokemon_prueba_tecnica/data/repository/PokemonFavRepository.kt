package com.example.pokemon_prueba_tecnica.data.repository

import com.example.pokemon_prueba_tecnica.data.room.dao.PokemonRoomDao
import com.example.pokemon_prueba_tecnica.data.room.entities.PokemonFavEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonFavRepository @Inject constructor(private val pokemonFavDao: PokemonRoomDao) {

    fun isPokemonFavorite(pokemonId: String): Flow<Boolean> =
        pokemonFavDao.isFavorite(pokemonId)

    fun getAllFavorites(): Flow<List<PokemonFavEntity>> =
        pokemonFavDao.getAllPokemonFav()

    suspend fun addToFavorites(pokemon: PokemonFavEntity) {
        pokemonFavDao.addFav(pokemon)
    }

    suspend fun removeFromFavorites(pokemonId: String) {
        pokemonFavDao.removeFav(pokemonId)
    }


}