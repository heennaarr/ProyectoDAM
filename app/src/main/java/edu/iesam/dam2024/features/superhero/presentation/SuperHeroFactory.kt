package edu.iesam.dam2024.features.superhero.presentation

import SuperHeroMockRemoteDataSource
import android.content.Context
import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase


class SuperHeroFactory(private val context: Context) {
    private val superHeroMockRemote = SuperHeroMockRemoteDataSource()
    private val superHeroLocal = SuperHeroXmlLocalDataSource(context)
    private val superHeroDataRepository = SuperHeroDataRepository( superHeroMockRemote, superHeroLocal)
    private val getSuperHeroesUseCase = GetSuperHeroesUseCase(superHeroDataRepository)
    private val getSuperHeroeSelectedUseCase = GetSuperHeroSelectedUseCase(superHeroDataRepository)



    fun buildViewModel(): SuperHeroViewModel //Esto crea un objeto como con new en java
    {

        return SuperHeroViewModel(getSuperHeroesUseCase) //NO SE PUEDE CREAR UN
    }
    fun buildSuperHeroDetailViewModel():SuperHeroDetailViewModel{
        return SuperHeroDetailViewModel(getSuperHeroeSelectedUseCase)
    }
}



    // OBJETO DE UNA INSTANCIA pero de una clase si por lo que hacemos que la instancia
        // esté en una clase haciendolo llegar por parametro //dependencia con el view model




