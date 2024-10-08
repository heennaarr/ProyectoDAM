package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase
):ViewModel(){
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState
    fun viewCreated(){
        _uiState.value = (UiState(isLoading = true))
        viewModelScope.launch(Dispatchers.IO) {
            val superheroes = getSuperHeroesUseCase.invoke()
            delay(5000)
            _uiState.postValue(UiState(superheroes = superheroes))
        }
    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superheroes : List<SuperHero>? = null
    )


}

