package com.example.viewmodelapp.data

import android.util.Log
import com.example.viewmodelapp.model.PokemonListModel
import com.example.viewmodelapp.service.ApiService
import com.example.viewmodelapp.service.RetrofitInstance
import retrofit2.Response

interface PokemonListRepositoryInterface {
    suspend fun getPokemonList(offset: Int, limit: Int): Response<PokemonListModel>
}

class PokemonListRepository(
    private val apiService: ApiService = RetrofitInstance.api // Asegúrate de que RetrofitInstance está correctamente definido
) : PokemonListRepositoryInterface {

    override suspend fun getPokemonList(offset: Int, limit: Int): Response<PokemonListModel> {
        Log.d("PokemonListRepository", "Fetching Pokemon list: offset=$offset, limit=$limit")
        return apiService.getPokemonList(offset, limit)
    }
}
