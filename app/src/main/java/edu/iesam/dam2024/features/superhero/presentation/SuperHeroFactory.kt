package edu.iesam.dam2024.features.superhero.presentation

import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository


class SuperHeroFactory(private val superHeroRepository: SuperHeroRepository) {
    fun buildViewModel(): SuperHeroViewModel //Esto crea un objeto como con new en java
    {
        val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroRepository)
        val getSuperHeroSelectedUseCase = GetSuperHeroSelectedUseCase(superHeroRepository)

        return SuperHeroViewModel(getSuperHeroesUseCase, getSuperHeroSelectedUseCase) //NO SE PUEDE CREAR UN
        // OBJETO DE UNA INSTANCIA pero de una clase si por lo que hacemos que la instancia
        // esté en una clase haciendolo llegar por parametro //dependencia con el view model
    }


}
