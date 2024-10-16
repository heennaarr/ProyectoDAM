package edu.iesam.dam2024.features.pokemon.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonXmlLocalDataSource(private val context: Context) {
    private val sharedPref = context.getSharedPreferences(
        "pokemon",Context.MODE_PRIVATE
    )

    private val gson = Gson()

    fun save(pokemon: Pokemon){
        sharedPref
            .edit().apply {
                putString("id", pokemon.id)
                putString("nombre", pokemon.nombre)
                putString("abilitys", pokemon.abilitys)
                putString("type", pokemon.type)
                putString("imagen", pokemon.imagen)
                apply()
            }
    }

    fun saveAll(pokemons: List<Pokemon>){
        val editor = sharedPref.edit()
        pokemons.forEach{ pokemon ->
            editor.putString(pokemon.id, gson.toJson(pokemon))
            }
        editor.apply()
    }

    fun find(): Pokemon{
        sharedPref.apply{
            return Pokemon(
                getString("id", "")!!,
                getString("nombre", "")!!,
                getString("abilitys", "")!!,
                getString("type", "")!!,
                getString("imagen", "")!!,
            )
        }
    }

    fun findAll(): List<Pokemon>{
        val pokemons = ArrayList<Pokemon>()
        val mapPokemons = sharedPref.all
        mapPokemons.values.forEach{ jsonPokemon ->
            val pokemon = gson.fromJson(jsonPokemon as String, Pokemon::class.java)
            pokemons.add(pokemon)
        }
        return pokemons
    }
    fun findById(pokemonId:String):Pokemon?{
        return sharedPref.getString(pokemonId, null)?.let{pokemon->
            gson.fromJson(pokemon,Pokemon::class.java)
        }
    }
    fun delete(){
        sharedPref.edit().clear().apply()
    }

    fun deleteById(pokemonId:String){
        sharedPref.edit().remove(pokemonId).apply()

    }




}