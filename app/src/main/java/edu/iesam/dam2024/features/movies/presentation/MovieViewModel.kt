package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

//funcion es pintar en la vista lo que le devuelve el caso de uso
//un viewmodel puede recibir todos los casos de uso que necesite esa vista
class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase): ViewModel() {

    fun viewCreated(): List<Movie>{
        return getMoviesUseCase.invoke()
    }

}