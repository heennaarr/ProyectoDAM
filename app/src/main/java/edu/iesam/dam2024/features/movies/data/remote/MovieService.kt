package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    //REST API: GET, POST, PUT, DELETE
    @GET("tasks")
    //Si usamos corrutina es con response, si no es Call
    suspend fun requestMovies(): Response<List<Movie>>

}