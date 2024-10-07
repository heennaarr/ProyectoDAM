package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val getMovieSelectedUseCase: GetMovieSelectedUseCase
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState
    fun viewCreated(movieId: String){
        viewModelScope.launch(Dispatchers.IO) {
            val movie = getMovieSelectedUseCase.invoke(movieId)
            _uiState.postValue(UiState(movie = movie))
        }
    }
    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val movie : Movie? = null
    )
}