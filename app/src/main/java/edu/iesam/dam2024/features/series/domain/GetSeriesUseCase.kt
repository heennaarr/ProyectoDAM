package edu.iesam.dam2024.features.series.domain

import edu.iesam.dam2024.features.series.data.SerieDataRepository

class GetSeriesUseCase(private val serieRepository: SerieDataRepository) {
    operator fun invoke(){
        return serieRepository.getSeries()
    }

}