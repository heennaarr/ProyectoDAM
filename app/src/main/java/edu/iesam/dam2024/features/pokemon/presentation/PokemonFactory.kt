package edu.iesam.dam2024.features.pokemon.presentation

import android.content.Context
import edu.iesam.dam2024.features.pokemon.data.PokemonDataRepository
import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonSelectedUseCase
import edu.iesam.dam2024.features.pokemon.domain.GetPokemonsUseCase

class PokemonFactory(private val context: Context) {
    private val pokemonMockRemote = PokemonMockRemoteDataSource()
    private val pokemonLocal = PokemonXmlLocalDataSource(context)
    private val pokemonDataRepository = PokemonDataRepository(pokemonMockRemote, pokemonLocal)
    private val getPokemonsUseCase = GetPokemonsUseCase(pokemonDataRepository)
    private val getPokemonSelectedUseCase = GetPokemonSelectedUseCase(pokemonDataRepository)

    fun buildPokemonListViewModel(): PokemonViewModel {
        return PokemonViewModel(getPokemonsUseCase)
    }
    fun buildPokemonDetailViewModel(): PokemonDetailViewModel {
        return PokemonDetailViewModel(getPokemonSelectedUseCase)
    }



}