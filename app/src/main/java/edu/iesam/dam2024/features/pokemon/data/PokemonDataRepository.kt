package edu.iesam.dam2024.features.pokemon.data

import edu.iesam.dam2024.features.pokemon.data.local.PokemonXmlLocalDataSource
import edu.iesam.dam2024.features.pokemon.data.remote.PokemonMockRemoteDataSource
import edu.iesam.dam2024.features.pokemon.domain.Pokemon
import edu.iesam.dam2024.features.pokemon.domain.PokemonRepository

class PokemonDataRepository(
    private val pokemonMockRemoteDataSource: PokemonMockRemoteDataSource,
    private val local: PokemonXmlLocalDataSource
): PokemonRepository {
    override fun getPokemons(): List<Pokemon> {
        val pokemonFromLocal = local.findAll()
        return if (pokemonFromLocal.isEmpty()) {
            val pokemonFromRemote = pokemonMockRemoteDataSource.getPokemons()
            local.saveAll(pokemonFromRemote)
            pokemonFromRemote
        } else {
            pokemonFromLocal
        }
    }

    override fun getPokemon(PokemonId: String): Pokemon? {
        val localPokemon = local.findById(PokemonId)
        if(localPokemon== null){
            pokemonMockRemoteDataSource.getPokemon(PokemonId)?.let{
                local.save(it)
                return it
            }
            }
        return localPokemon
    }

}