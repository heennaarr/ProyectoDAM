package edu.iesam.dam2024.features.superhero.data

import SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository (private val superHeroDataRepository: SuperHeroMockRemoteDataSource):SuperHeroRepository {
    override fun getSuperHeroes(): List<SuperHero> {
        return superHeroDataRepository.getSuperheroes()
    }

}