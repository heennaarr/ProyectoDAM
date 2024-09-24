package edu.iesam.dam2024.features.superhero.data

import SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroDataRepository (private val superHeroDataSource: SuperHeroMockRemoteDataSource):SuperHeroRepository {
    override fun getSuperHeroes(): List<SuperHero> {
        return superHeroDataSource.getSuperheroes()
    }

    override fun getSuperHeroSelected(superHeroId: String): SuperHero? {
        return superHeroDataSource.getSuperHeroSelected(superHeroId)
    }

}