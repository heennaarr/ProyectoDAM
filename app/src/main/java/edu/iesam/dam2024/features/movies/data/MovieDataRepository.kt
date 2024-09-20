/**
 * Naming: Modelo + DataRepository
 */
package edu.iesam.dam2024.features.movies.data

import MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

//Coordinadora de todas las fuentes de datos
//recibe por parametro todas las fuentes de datos que puede gestionar

class MovieDataRepository (private val mockRemoteDataSource: MovieMockRemoteDataSource):MovieRepository{

    override fun getMovies(): List<Movie>{
        return mockRemoteDataSource.getMovies()
    }

}