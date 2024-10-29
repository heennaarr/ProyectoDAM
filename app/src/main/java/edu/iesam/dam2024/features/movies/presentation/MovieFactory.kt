package edu.iesam.dam2024.features.movies.presentation

import MovieApiRemoteDataSource
import MovieMockRemoteDataSource
import android.content.Context
import MovieDataRepository
import edu.iesam.dam2024.app.data.api.ApiClient
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase

/**
 * Esta clase solo va a crear objetos
 */
class MovieFactory(private val context: Context) {
    private val movieLocal = MovieXmlLocalDataSource(context)

    // Fixed argument order here
    private val movieDataRepository = MovieDataRepository(getMovieApiRemoteDataSource(), movieLocal)

    val getMoviesUseCase = GetMoviesUseCase(movieDataRepository)
    val getMovieSelectedUseCase = GetMovieSelectedUseCase(movieDataRepository)

    fun getMoviesListViewModel(): MovieViewModel {
        return MovieViewModel(getMoviesUseCase)

    }
    fun builMovieDetailViewModel(): MovieDetailViewModel {
        return MovieDetailViewModel(getMovieSelectedUseCase)
    }
   private fun getMovieApiRemoteDataSource(): MovieApiRemoteDataSource {
        val movieService = ApiClient.provideMovieService(ApiClient.provideRetrofit())
        return MovieApiRemoteDataSource(movieService)

    }
    /* fun buildViewModel(): MovieViewModel {
         return MovieViewModel(getMoviesUseCase)
     }
     fun buildMovieDetailViewModel(): MovieDetailViewModel {
         return MovieDetailViewModel(getMovieSelectedUseCase)
     }*/
}