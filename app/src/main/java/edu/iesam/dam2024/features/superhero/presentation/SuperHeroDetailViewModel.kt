package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroDetailViewModel(private val getSuperHeroSelectedUseCase: GetSuperHeroSelectedUseCase):ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState
    fun viewCreated(movieId: String){
        viewModelScope.launch(Dispatchers.IO) {
            val superhero = getSuperHeroSelectedUseCase.invoke(movieId)
            _uiState.postValue(UiState(superhero = superhero))
        }
    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superhero : SuperHero? = null
    )
}