package edu.iesam.dam2024.features.pokemon.data.remote

import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonMockRemoteDataSource {
    private val Pokemons = listOf(
        Pokemon(
            "1",
            "pikachu32",
            "rayo",
            "electrico",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"

        ),
        Pokemon(
            "2",
            "pikachu3",
            "rayo",
            "electrico",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
        ),
        Pokemon(
            "3",
             "pikachu",
            "rayo",
            "electrico",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png"
        )

    )
    fun getPokemons(): List<Pokemon> {
        return Pokemons
    }
    fun getPokemon(PokemonId: String): Pokemon? {
        return Pokemons.firstOrNull { it.id == PokemonId }
    }
}