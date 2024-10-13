package edu.iesam.dam2024.features.pokemon.domain

interface PokemonRepository {
    fun getPokemons(): List<Pokemon>
    fun getPokemon(PokemonId: String): Pokemon?

}