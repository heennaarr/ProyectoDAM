package edu.iesam.dam2024.features.pokemon.domain

import edu.iesam.dam2024.features.pokemon.data.PokemonDataRepository

class GetPokemonSelectedUseCase(private val pokemonRepository: PokemonDataRepository) {
    operator fun invoke(pokemonId: String): Pokemon? {
        return pokemonRepository.getPokemon(pokemonId)

    }
}