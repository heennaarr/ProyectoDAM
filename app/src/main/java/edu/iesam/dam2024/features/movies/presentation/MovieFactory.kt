package edu.iesam.dam2024.features.movies.presentation

import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.MovieRepository

/**
 * Esta clase solo va a crear objetos
 */
class MovieFactory(private val movieRepository: MovieRepository) {

    fun buildViewModel(): MovieViewModel {
        val getMoviesUseCase = GetMoviesUseCase(movieRepository)
        val getMovieSelectedUseCase = GetMovieSelectedUseCase(movieRepository)

        return MovieViewModel(getMoviesUseCase, getMovieSelectedUseCase)
    }
}
