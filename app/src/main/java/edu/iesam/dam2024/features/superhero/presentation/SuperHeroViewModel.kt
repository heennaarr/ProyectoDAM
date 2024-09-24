package edu.iesam.dam2024.features.superhero.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.movies.domain.GetMovieSelectedUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroSelectedUseCase
import edu.iesam.dam2024.features.superhero.domain.GetSuperHeroesUseCase
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroViewModel(
    private val getSuperHeroesUseCase: GetSuperHeroesUseCase,
    private val getSuperHeroSelectedUseCase: GetSuperHeroSelectedUseCase
):ViewModel(){
    fun viewCreated(): List<SuperHero>{
        return getSuperHeroesUseCase.invoke()
    }

    fun itemSelected(superHeroId: String): SuperHero? {

        return getSuperHeroSelectedUseCase.invoke(superHeroId)
    }
}

