package edu.iesam.dam2024.features.movies.domain

class GetMovieSelectedUseCase(private val movieRepository: MovieRepository) {

        operator fun invoke(movieId: String): Movie? {
            return movieRepository.getMovie(movieId)
        }


    }
