package com.example.pokemon_prueba_tecnica.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokemon_prueba_tecnica.ui.viewmodels.PokemonDetailViewModel
import com.example.pokemon_prueba_tecnica.ui.viewmodels.PokemonListViewModel
import com.example.pokemon_prueba_tecnica.ui.views.PokemonDetailView
import com.example.pokemon_prueba_tecnica.ui.views.PokemonListScreen

@Composable
fun NavManager(
    navController: NavController,
    pokemonViewModel: PokemonListViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel,


    ) {

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = "pokemon_home") {


        composable("pokemon_home") {
            PokemonListScreen(pokemonViewModel, navController)
        }


        composable(
            route = "pokemon_detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")
            id?.let {
                PokemonDetailView(
                    navController = navController,
                    pokemonDetailViewModel = pokemonDetailViewModel,
                    id = it
                )
            }
        }
    }
}
