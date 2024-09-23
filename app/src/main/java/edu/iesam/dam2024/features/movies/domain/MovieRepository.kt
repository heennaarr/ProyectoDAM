package edu.iesam.dam2024.features.movies.domain

/**
 * Tipo de clase donde se definen los metodos pero no se implementan
 *
 */
//eS LA FORMA PARA IR DE DENTRO HACIA FUERA
interface MovieRepository {
    fun getMovies(): List<Movie>
    fun getMovie(movieId: String): Movie?
}