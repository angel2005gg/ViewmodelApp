package com.example.viewmodelapp.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.viewmodelapp.model.PokemonListModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import android.util.Log
import com.example.viewmodelapp.data.PokemonListRepository
import com.example.viewmodelapp.data.PokemonListRepositoryInterface

class PokemonListViewModel(
    private val repositorio: PokemonListRepositoryInterface = PokemonListRepository()
) : ViewModel() {
    private val _pokemonList = MutableStateFlow<PokemonListModel?>(null)
    private val _errorMessage = MutableStateFlow<String?>(null)
    private val _isLoading = MutableStateFlow<Boolean>(true)

    val pokemonList: StateFlow<PokemonListModel?> get() = _pokemonList
    val errorMessage: StateFlow<String?> get() = _errorMessage
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun getPokemonList() {
        viewModelScope.launch {
            _isLoading.value = true
            val respuesta = repositorio.getPokemonList(0, 150)
            if (respuesta.isSuccessful) {
                val cuerpo = respuesta.body()
                if (cuerpo != null) {
                    _isLoading.value = false
                    _pokemonList.value = cuerpo
                }
            } else {
                val error = respuesta.errorBody()
                if (error != null) {
                    _isLoading.value = false
                    _errorMessage.value = error.string()
                }
            }
        }
    }
}

