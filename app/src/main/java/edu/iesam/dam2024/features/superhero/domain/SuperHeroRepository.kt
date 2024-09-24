package edu.iesam.dam2024.features.superhero.domain

import edu.iesam.dam2024.features.movies.domain.Movie


interface SuperHeroRepository {
    fun getSuperHeroes(): List<SuperHero>
    fun getSuperHeroSelected(superHeroId: String):SuperHero?


}