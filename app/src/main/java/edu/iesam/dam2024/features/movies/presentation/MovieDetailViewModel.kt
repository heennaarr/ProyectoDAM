package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
class MovieDetailViewModel(
    private val getMovieSelectedUseCase: GetMovieSelectedUseCase
) : ViewModel() {
    fun viewCreated(movieId: String): Movie? {
        return getMovieSelectedUseCase.invoke(movieId)
    }
}