package edu.iesam.dam2024.features.superhero.presentation

import SuperHeroMockRemoteDataSource
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.superhero.data.SuperHeroDataRepository
import edu.iesam.dam2024.features.superhero.data.local.SuperHeroXmlLocalDataSource
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository
import edu.iesam.dam2024.features.movies.presentation.MovieDetailActivity.Companion.KEY_SUPERHERO_ID
class SuperHeroActivity : AppCompatActivity() {

    private val superHeroRepository: SuperHeroRepository = SuperHeroDataRepository(SuperHeroMockRemoteDataSource())
    private val superHeroFactory: SuperHeroFactory = SuperHeroFactory(superHeroRepository)
    private val viewModel: SuperHeroViewModel = superHeroFactory.buildViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        val superheroes =viewModel.viewCreated()
        bindData(superheroes)
        Log.d("@dev", superheroes.toString())
        //textXml()
        testListXml()

    }
    private fun bindData(superheroes: List<SuperHero>){
        //Cuando usamos bind lo que queremos es asignar datos a elementos de las vistas
        findViewById<TextView>(R.id.superhero_id_1).text = superheroes[0].id
        findViewById<TextView>(R.id.superhero_alias_1).text = superheroes[0].alias
        findViewById<TextView>(R.id.superhero_superPoder_1).text = superheroes[0].superPoder
        //R de recursos, eliges id y despues el id correspondiente, .text es una opcion que rellenas aqui para el layour
        findViewById<TextView>(R.id.superhero_id_2).text = superheroes[1].id
        findViewById<TextView>(R.id.superhero_alias_2).text = superheroes[1].alias
        findViewById<TextView>(R.id.superhero_superPoder_2).text = superheroes[1].superPoder

        findViewById<TextView>(R.id.superhero_id_3).text = superheroes[2].id
        findViewById<TextView>(R.id.superhero_alias_3).text = superheroes[2].alias
        findViewById<TextView>(R.id.superhero_superPoder_3).text = superheroes[2].superPoder

        findViewById<TextView>(R.id.superhero_id_4).text = superheroes[3].id
        findViewById<TextView>(R.id.superhero_alias_4).text = superheroes[3].alias
        findViewById<TextView>(R.id.superhero_superPoder_4).text = superheroes[3].superPoder

        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener{
            navigateToMovieDetail(movies[0].id)


        }
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener{
            viewModel.itemSelected(superheroes[1].id)
            val movie2: SuperHero? =viewModel.itemSelected(superheroes[1].id)
            movie2?.let {
                Log.d("@dev" , "Superheroe seleccionado: ${it.alias}")
            }

        }


    }
   private fun navigateToMovieDetail(superHeroId:String){
       startActivity(SuperHeroDetailActivity.getIntent(this, superHeroId))
   }



}



