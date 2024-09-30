package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.MovieDataRepository

class GetMovieSelectedUseCase(private val movieRepository: MovieDataRepository) {

        operator fun invoke(movieId: String): Movie? {
            return movieRepository.getMovie(movieId)
        }


    }
