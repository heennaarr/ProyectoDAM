package edu.iesam.dam2024.features.superhero.data.local

import SuperHeroMockRemoteDataSource
import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {
    private val gson = Gson()
    private val sharedPref=context.getSharedPreferences(
        "superhero", Context.MODE_PRIVATE
    )


    fun save(superHero: SuperHero){
        val editor = sharedPref.edit()
        editor.putString("id", superHero.id)
        editor.putString("nombre", superHero.nombre)
        editor.putString("alias", superHero.alias)
        editor.apply()

    }
    fun saveAll(superHeroes: List<SuperHero>) {
        val editor = sharedPref.edit()
        superHeroes.forEach { superhero ->
            editor.putString(superhero.id, gson.toJson(superhero))
        }
        editor.apply()
    }
    fun find():SuperHero{
        sharedPref.apply {
            val id = getString("id", "")
            val nombre = getString("title", "")
            val alias = getString("poster", "")
            return SuperHero(
                getString("id", "")!!,
                getString("nombre", "")!!,
                getString("alias", "")!!,
                getString("superpoder" , "")!!,
                getInt("años" , 0),
                getString("ocupacion" , "")!!,
                getString("lugarDeNacimiento" , "")!!,
                getString("imagen" , "")!!,
                getString("publisher" , "")!!,
            )
        }
    }
    fun findAll(): List<SuperHero>{
        val superHeroes = ArrayList<SuperHero>()
        val mapSuperHero = sharedPref.all //as Map<String, String>
        mapSuperHero.values.forEach { jsonSuperHero ->
            val superHero = gson.fromJson(jsonSuperHero as String, SuperHero::class.java)
            superHeroes.add(superHero)
        }
        return superHeroes
    }

    fun delete(){
        sharedPref.edit().clear().apply()
    }
}