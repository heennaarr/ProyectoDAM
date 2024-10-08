package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {

   private lateinit var  superHeroFactory: SuperHeroFactory
   private lateinit var viewModel: SuperHeroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()
        setupObserver()
        viewModel.viewCreated()



    }
    private fun setupObserver(){
        val superheroObserver = Observer<SuperHeroViewModel.UiState>{ uistate->
            uistate.superheroes?.let {
                bindData(it)
            }
            uistate.errorApp?.let {
                //pinto el error
            }
            if(uistate.isLoading){
                //Muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")

            }
        }
        viewModel.uiState.observe(this, superheroObserver)

    }
     fun bindData(superheroes: List<SuperHero>){
        //Cuando usamos bind lo que queremos es asignar datos a elementos de las vistas
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_alias_1).text = superheroes[0].alias
        findViewById<TextView>(R.id.superhero_superPoder_1).text = superheroes[0].superPoder
        val imageView = findViewById<ImageView>(R.id.layoutfotoSuperhero1)
        Glide
            .with(this)
            .load(superheroes[0].imagen)
            .into(imageView)
        findViewById<LinearLayout>(R.id.layout_superhero_1).setOnClickListener{
            navigateToSuperHeroDetail(superheroes[0].id)


        }
        //R de recursos, eliges id y despues el id correspondiente, .text es una opcion que rellenas aqui para el layour
        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_alias_2).text = superheroes[1].alias
        findViewById<TextView>(R.id.superhero_superPoder_2).text = superheroes[1].superPoder
        val imageView2 = findViewById<ImageView>(R.id.layoutfotoSuperhero2)
        Glide
            .with(this)
            .load(superheroes[1].imagen)
            .into(imageView2)
        findViewById<LinearLayout>(R.id.layout_superhero_2).setOnClickListener{
            navigateToSuperHeroDetail(superheroes[1].id)


        }

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_alias_3).text = superheroes[2].alias
        findViewById<TextView>(R.id.superhero_superPoder_3).text = superheroes[2].superPoder
        val imageView3 = findViewById<ImageView>(R.id.layoutfotoSuperhero3)
        Glide
            .with(this)
            .load(superheroes[2].imagen)
            .into(imageView3)
        findViewById<LinearLayout>(R.id.layout_superhero_3).setOnClickListener{
            navigateToSuperHeroDetail(superheroes[2].id)


        }

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_alias_4).text = superheroes[3].alias
        findViewById<TextView>(R.id.superhero_superPoder_4).text = superheroes[3].superPoder
        val imageView4 = findViewById<ImageView>(R.id.layoutfotoSuperhero4)
        Glide
            .with(this)
            .load(superheroes[3].imagen)
            .into(imageView4)
        findViewById<LinearLayout>(R.id.layout_superhero_4).setOnClickListener{
            navigateToSuperHeroDetail(superheroes[3].id)


        }





    }

    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
            ErrorApp.TestErrorApp -> TODO()
        }
    }
    fun navigateToSuperHeroDetail(superHeroId:String){
       startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
   }



}



