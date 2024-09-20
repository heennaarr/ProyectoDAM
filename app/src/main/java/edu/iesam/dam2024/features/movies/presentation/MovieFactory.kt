package edu.iesam.dam2024.features.movies.presentation

import MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase

/**
 * Esta clase solo va a crear objetos
 */
class MovieFactory {
    fun buildViewModel():MovieViewModel //Esto crea un objeto como con new en java
            = MovieViewModel(GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource()))) //NO SE PUEDE CREAR UN
    // OBJETO DE UNA INSTANCIA pero de una clase si por lo que hacemos que la instancia
    // esté en una clase haciendolo llegar por parametro //dependencia con el view model
}