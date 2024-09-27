package edu.iesam.dam2024.features.superhero.data.local

import SuperHeroMockRemoteDataSource
import android.content.Context
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
}