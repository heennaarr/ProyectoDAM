package edu.iesam.dam2024.features.series.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.series.domain.GetSeriesUseCase
import edu.iesam.dam2024.features.series.domain.Serie

class SerieViewModel(
    private val getSeriesUseCase: GetSeriesUseCase
) :ViewModel(){
    fun viewCreated(): List<Serie> {
        return getSeriesUseCase.invoke()
    }
}