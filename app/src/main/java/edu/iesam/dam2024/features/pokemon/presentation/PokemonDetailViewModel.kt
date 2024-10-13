package edu.iesam.dam2024.features.pokemon.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.pokemon.domain.ErrorApp
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonSelectedUseCase
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val getPokemonSelectedUseCase: GetPokemonSelectedUseCase
): ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(pokemonId: String){
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = getPokemonSelectedUseCase.invoke(pokemonId)
            _uiState.postValue(UiState(pokemon = pokemon))
        }

    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val pokemon : Pokemon? = null
    )
}