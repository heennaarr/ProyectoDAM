package edu.iesam.dam2024.features.movies.data

import MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

// Coordinadora de todas las fuentes de datos
// Recibe por parámetro todas las fuentes de datos que puede gestionar

class MovieDataRepository(
    private val mockRemoteDataSource: MovieMockRemoteDataSource,
    private val local: MovieXmlLocalDataSource
): MovieRepository {
    override fun getMovies(): List<Movie> {
        val movieFromLocal = local.findAll()
        return if (movieFromLocal.isEmpty()) {
            val moviesFromRemote = mockRemoteDataSource.getMovies()
            local.saveAll(moviesFromRemote)
            moviesFromRemote
        } else {
            movieFromLocal
        }
    }

    override fun getMovie(movieId: String): Movie? {
        val localMovie = local.findById(movieId)
        if(localMovie== null){
             mockRemoteDataSource.getMovie(movieId)?.let{
                 local.save(it)
                 return it
             }
        }
        return localMovie
    }
}
