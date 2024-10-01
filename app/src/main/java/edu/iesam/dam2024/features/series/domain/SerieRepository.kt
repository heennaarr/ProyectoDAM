package edu.iesam.dam2024.features.series.domain

interface SerieRepository {
    fun getSeries():List<Serie>
}