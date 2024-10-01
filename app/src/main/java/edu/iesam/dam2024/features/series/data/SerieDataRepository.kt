package edu.iesam.dam2024.features.series.data


import MovieMockRemoteDataSource
import edu.iesam.dam2024.features.series.data.remote.SerieMockRemoteDataSource
import edu.iesam.dam2024.features.series.domain.Serie
import edu.iesam.dam2024.features.series.domain.SerieRepository

class SerieDataRepository(private val mockRemoteDataSource: SerieMockRemoteDataSource): SerieRepository {
    val datosremotos = SerieMockRemoteDataSource()
    override fun getSeries(): List<Serie>{
        return datosremotos.getSeries()

    }





}