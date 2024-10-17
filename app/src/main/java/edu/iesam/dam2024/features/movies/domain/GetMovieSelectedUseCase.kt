package edu.iesam.dam2024.features.movies.domain

import MovieDataRepository

class GetMovieSelectedUseCase(private val movieRepository: MovieDataRepository) {

        operator fun invoke(movieId: String): Movie? {
            return movieRepository.getMovie(movieId)
        }


    }
