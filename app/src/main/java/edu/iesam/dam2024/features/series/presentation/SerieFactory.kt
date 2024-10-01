package edu.iesam.dam2024.features.series.presentation

import android.content.Context
import edu.iesam.dam2024.features.series.data.SerieDataRepository
import edu.iesam.dam2024.features.series.data.remote.SerieMockRemoteDataSource

class SerieFactory(private val context: Context) {
    private val remoto = SerieMockRemoteDataSource()
    private val serieDataRepository= SerieDataRepository(remoto)
}