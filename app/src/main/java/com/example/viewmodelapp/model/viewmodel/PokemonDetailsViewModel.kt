package com.example.viewmodelapp.model.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelapp.data.PokemonDetailsRepository
import com.example.viewmodelapp.model.PokemonDetailsModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonDetailsViewModel(
    private val repository: PokemonDetailsRepository = PokemonDetailsRepository()
) : ViewModel() {

    // Estados mutables
    private val _pokemonDetails = MutableStateFlow<PokemonDetailsModel?>(null)
    private val _isLoading = MutableStateFlow(true)
    private val _gotError = MutableStateFlow(false)

    // Estados
    val pokemonDetails: StateFlow<PokemonDetailsModel?> get() = _pokemonDetails
    val isLoading: StateFlow<Boolean> get() = _isLoading
    val gotError: StateFlow<Boolean> get() = _gotError

    // Función para obtener detalles
    fun fetchDetails(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result: Response<PokemonDetailsModel> = repository.getPokemonDetails(name)
            _isLoading.value = false
            if (result.isSuccessful && result.body() != null) {
                _pokemonDetails.value = result.body()
            } else {
                _gotError.value = true
            }
        }
    }
}
