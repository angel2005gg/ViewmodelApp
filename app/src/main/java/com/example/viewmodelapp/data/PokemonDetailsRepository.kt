package com.example.viewmodelapp.data


import com.example.viewmodelapp.service.ApiService
import com.example.viewmodelapp.model.PokemonDetailsModel
import com.example.viewmodelapp.service.RetrofitInstance
import retrofit2.Response

interface PokemonDetailsRepositoryInterface {
    suspend fun getPokemonDetails(name: String): Response<PokemonDetailsModel>
}

class PokemonDetailsRepository(
    private val apiService: ApiService = RetrofitInstance.api // Asegúrate de que esta línea esté correcta según tu implementación de Retrofit
) : PokemonDetailsRepositoryInterface {
    override suspend fun getPokemonDetails(name: String): Response<PokemonDetailsModel> {
        return apiService.getPokemonDetails(name)
    }
}
