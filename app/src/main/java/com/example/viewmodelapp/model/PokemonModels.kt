package com.example.viewmodelapp.model

// Clase para representar la lista de Pokémon
data class Resultados(
    val resultados: List<Pokemon>
)

// Clase para representar un Pokémon
data class Pokemon(
    val nombre: String
)
