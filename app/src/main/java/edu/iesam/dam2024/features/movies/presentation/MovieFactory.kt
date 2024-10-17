package edu.iesam.dam2024.features.movies.presentation

import MovieApiRemoteDataSource
import MovieMockRemoteDataSource
import android.content.Context
import MovieDataRepository
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase

/**
 * Esta clase solo va a crear objetos
 */
class MovieFactory(private val context: Context) {
    private val movieMockRemote = MovieApiRemoteDataSource()
    private val movieLocal = MovieXmlLocalDataSource(context)

    // Fixed argument order here
    private val movieDataRepository = MovieDataRepository(movieMockRemote, movieLocal)

    val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    val getMovieSelectedUseCase = GetMovieSelectedUseCase(movieDataRepository)

    fun getMoviesListViewModel(): MovieViewModel {
        return MovieViewModel(getMoviesUseCase)

    }
    fun builMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieSelectedUseCase)
    }
    /* fun buildViewModel(): MovieViewModel {
         return MovieViewModel(getMoviesUseCase)
     }
     fun buildMovieDetailViewModel(): MovieDetailViewModel {
         return MovieDetailViewModel(getMovieSelectedUseCase)
     }*/
}