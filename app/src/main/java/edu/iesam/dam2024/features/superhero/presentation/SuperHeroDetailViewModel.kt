package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailViewModel(private val getSuperHeroSelectedUseCase: GetSuperHeroSelectedUseCase):ViewModel() {
    fun viewCreated(superheroId:String):SuperHero?{
        return getSuperHeroSelectedUseCase.invoke(superheroId)
    }
}