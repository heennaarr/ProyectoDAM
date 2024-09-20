package edu.iesam.dam2024.features.superhero.domain


interface SuperHeroRepository {
    fun getSuperHeroes(): List<SuperHero>

}