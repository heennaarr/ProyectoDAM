package edu.iesam.dam2024.features.pokemon.domain

import edu.iesam.dam2024.features.pokemon.data.PokemonDataRepository

class GetPokemonsUseCase(private val pokemonRepository: PokemonDataRepository) {
    operator fun invoke(): List<Pokemon> {
        return pokemonRepository.getPokemons()

}




}