package com.example.pokemon_prueba_tecnica.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.example.pokemon_prueba_tecnica.data.API.ApiService
import com.example.pokemon_prueba_tecnica.data.room.PokemonDatabase
import com.example.pokemon_prueba_tecnica.data.room.dao.PokemonRoomDao
import com.example.pokemon_prueba_tecnica.data.room.dao.SavedPokemonDao
import com.example.pokemon_prueba_tecnica.ui.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun providesPokemonRowDao(db: PokemonDatabase): PokemonRoomDao {
        return db.pokemonDao()
    }

    @Provides
    fun providesSearchQueryDao(db: PokemonDatabase): SavedPokemonDao {
        return db.savedPokemonDao()
    }

    @Singleton
    @Provides
    fun providesFormsDataBase(@ApplicationContext context: Context): PokemonDatabase {
        return databaseBuilder(
            context,
            PokemonDatabase::class.java,
            "pkmn_db"
        ).fallbackToDestructiveMigration().build()
    }


    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(25, TimeUnit.SECONDS) // Tiempo de espera para conexión
            .readTimeout(25, TimeUnit.SECONDS)    // Tiempo de espera para lectura
            .writeTimeout(25, TimeUnit.SECONDS)

            .build()
    }



    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}