package edu.iesam.dam2024.features.superhero.presentation

import SuperHeroMockRemoteDataSource
import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase



class SuperHeroFactory {
    fun buildViewModel(): SuperHeroViewModel //Esto crea un objeto como con new en java
            = SuperHeroViewModel(GetSuperHeroesUseCase(SuperHeroDataRepository(SuperHeroMockRemoteDataSource()))) //NO SE PUEDE CREAR UN
    // OBJETO DE UNA INSTANCIA pero de una clase si por lo que hacemos que la instancia
    // esté en una clase haciendolo llegar por parametro //dependencia con el view model
}
