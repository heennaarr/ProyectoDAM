package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import com.bumptech.glide.Glide
import edu.iesam.dam2024.R

import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailActivity : AppCompatActivity() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()
        getSuperHeroId()?.let { superheroId ->
            viewModel.viewCreated(superheroId)
        }
        setupObserver()
    }
    private fun setupObserver(){
        val superHeroObserver = Observer<SuperHeroDetailViewModel.UiState> { uistate ->
            uistate.superhero?.let {
                bindData(it)
            }
            uistate.errorApp?.let {
                //pinto el error
            }
            if (uistate.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev", " Cargado ...")
            }
        }
        viewModel.uiState.observe(this, superHeroObserver)

    }
    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_SUPERHERO_ID)
    }
    private fun bindData(superHero: SuperHero) {
        val imageView = findViewById<ImageView>(R.id.imagen1)
        Glide
            .with(this)
            .load(superHero.imagen)
            .into(imageView)
    }
    companion object {
        val KEY_SUPERHERO_ID = "key_superhero_id"
        fun getIntent(context: Context, superHeroId: String): Intent {
            val intent = Intent(context, SuperHeroDetailActivity::class.java)
            intent.putExtra(KEY_SUPERHERO_ID, superHeroId)
            return intent
        }
    }
}