package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroActivity : AppCompatActivity() {

   private lateinit var  superHeroFactory: SuperHeroFactory
   private lateinit var viewModel: SuperHeroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildViewModel()

        val superheroes = viewModel.viewCreated()
        bindData(superheroes)


    }
    private fun bindData(superheroes: List<SuperHero>){
        //Cuando usamos bind lo que queremos es asignar datos a elementos de las vistas
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_alias_1).text = superheroes[0].alias
        findViewById<TextView>(R.id.superhero_superPoder_1).text = superheroes[0].superPoder

        findViewById<LinearLayout>(R.id.layout_superhero_1).setOnClickListener{
            navigateToMovieDetail(superheroes[0].id)


        }
        //R de recursos, eliges id y despues el id correspondiente, .text es una opcion que rellenas aqui para el layour
        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_alias_2).text = superheroes[1].alias
        findViewById<TextView>(R.id.superhero_superPoder_2).text = superheroes[1].superPoder
        findViewById<LinearLayout>(R.id.layout_superhero_2).setOnClickListener{
            navigateToMovieDetail(superheroes[1].id)


        }

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_alias_3).text = superheroes[2].alias
        findViewById<TextView>(R.id.superhero_superPoder_3).text = superheroes[2].superPoder
        findViewById<LinearLayout>(R.id.layout_superhero_3).setOnClickListener{
            navigateToMovieDetail(superheroes[2].id)


        }

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_alias_4).text = superheroes[3].alias
        findViewById<TextView>(R.id.superhero_superPoder_4).text = superheroes[3].superPoder
        findViewById<LinearLayout>(R.id.layout_superhero_4).setOnClickListener{
            navigateToMovieDetail(superheroes[3].id)


        }





    }
   private fun navigateToMovieDetail(superHeroId:String){
       startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
   }



}



