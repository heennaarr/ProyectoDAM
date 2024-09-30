package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.MovieDataRepository

/**
 * Naming: Verbo(acción)+ UseCase
 */
//funcion especial de Kotlin que invoca ese caso de uso. Da superpoderes para programacion funcional
// Las capas internas no pueden acceder a las capas internas
//un caso de uso puede tener todos los repositorios que quiera por constructor
// EL CASO DE USO NUNCA TIENE QUE TENER UN IMPORT A LA CAPA DE DATOS O A LA CASA DE PRESENTATION
class GetMoviesUseCase(private val movieRepository: MovieDataRepository) {
   //no hay ningun import de MovieRepository por que esta dentro de domain
    //un repositorio por cada entidad
    operator fun invoke(): List<Movie> {
        return movieRepository.getMovies()
    }
}