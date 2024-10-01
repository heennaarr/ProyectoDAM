package edu.iesam.dam2024.features.series.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.series.domain.Serie

class SerieMockRemoteDataSource {
    private val series = listOf(
        Serie("La casa de papel", "director1", "actor1" , 3),
        Serie("Expres", "director2", "actor2", 6),
        Serie("Dahmer", "director3", "actor3", 8),
        Serie(nombre = "Vis a vis", director = "director4", actorPrincipal = "actor4" , temporadas = 2)
    )
    fun getSeries(): List<Serie> {
        return series
    }

}