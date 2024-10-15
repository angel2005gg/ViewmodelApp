package com.example.viewmodelapp.model.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodelapp.data.PokemonListRepository
import com.example.viewmodelapp.data.PokemonListRepositoryInterface
import com.example.viewmodelapp.model.PokemonListItem
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val repository: PokemonListRepositoryInterface = PokemonListRepository()
) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonListItem>>()
    val pokemonList: LiveData<List<PokemonListItem>> = _pokemonList

    fun fetchPokemonList(offset: Int, limit: Int) {
        viewModelScope.launch {
            val response = repository.getPokemonList(offset, limit)
            if (response.isSuccessful) {
                _pokemonList.postValue(response.body()?.results ?: emptyList())
            } else {
                Log.e("PokemonViewModel", "Error fetching Pokemon list: ${response.errorBody()}")
            }
        }
    }
}
