package edu.iesam.dam2024.features.movies.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie

// Un ViewModel puede recibir todos los casos de uso que necesite la vista
class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase // Ahora añadimos este caso de uso
) : ViewModel() {

    // Llama al caso de uso para obtener la lista de películas
    fun viewCreated(): List<Movie> {
        return getMoviesUseCase.invoke()
    }

    // Llama al caso de uso para obtener la película seleccionada

}
