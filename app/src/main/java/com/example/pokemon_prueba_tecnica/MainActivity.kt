package com.example.pokemon_prueba_tecnica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pokemon_prueba_tecnica.ui.navigation.NavManager
import com.example.pokemon_prueba_tecnica.ui.theme.Pokemon_Prueba_TecnicaTheme
import com.example.pokemon_prueba_tecnica.ui.viewmodels.PokemonDetailViewModel
import com.example.pokemon_prueba_tecnica.ui.viewmodels.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pokemonListViewModel: PokemonListViewModel by viewModels()
        val pokemonDetailModel: PokemonDetailViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            Pokemon_Prueba_TecnicaTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavManager(navController = navController,pokemonListViewModel,pokemonDetailModel)

                }
            }
        }
    }
}
