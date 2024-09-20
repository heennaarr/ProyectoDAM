package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class SuperHeroActivity : AppCompatActivity() {

    private val superHeroviewFactory : SuperHeroFactory = SuperHeroFactory()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        val viewModel = superHeroviewFactory.buildViewModel()
        val superheroes =viewModel.viewCreated()
        Log.d("@dev", superheroes.toString())
    }
}