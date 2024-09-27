package edu.iesam.dam2024.features.superhero.data.local

import SuperHeroMockRemoteDataSource
import android.content.Context
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroXmlLocalDataSource(private val context: Context) {
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
    fun findAll():SuperHero{
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

    fun delete(){
        sharedPref.edit().clear().apply()
    }
}