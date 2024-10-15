package com.example.viewmodelapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.viewmodelapp.model.PokemonDetailsModel
import com.example.viewmodelapp.model.viewmodel.PokemonDetailsViewModel

@Composable
fun PokemonDetailsScreen(
    navController: NavController,
    nombre: String
) {
    val viewModel: PokemonDetailsViewModel = remember { PokemonDetailsViewModel() }

    // Obtener estados de LiveData
    val pokemonDetails = viewModel.pokemonDetails.collectAsState()
    val isLoading = viewModel.isLoading.collectAsState()
    val gotError = viewModel.gotError.collectAsState()

    // Llamar a la función para obtener detalles del Pokémon
    LaunchedEffect(nombre) {
        viewModel.fetchDetails(nombre)
    }

    // Mostrar contenido
    Content(
        isLoading = isLoading.value,
        gotError = gotError.value,
        pokemonDetails = pokemonDetails.value
    )
}

@Composable
private fun Content(
    isLoading: Boolean,
    gotError: Boolean,
    pokemonDetails: PokemonDetailsModel?
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(200.dp),
                color = Color.Blue,
                strokeWidth = 4.dp
            )
        } else if (gotError) {
            ErrorState()
        } else {
            pokemonDetails?.let { details ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(url = details.sprite.imageURL)
                    Text(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        text = details.name,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
private fun AsyncImage(url: String) {
    val painter = rememberImagePainter(data = url)

    Image(
        modifier = Modifier.size(200.dp),
        painter = painter,
        contentDescription = null
    )
}

@Composable
fun ErrorState() {
    // Implementa tu ErrorState aquí, similar a como lo hiciste anteriormente
    // por ejemplo:
    Text(text = "Ocurrió un error al cargar los detalles del Pokémon")
}
