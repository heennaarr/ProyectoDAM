package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R


//Es la parte cercana a la parte visual del usuario
class MovieActivity : AppCompatActivity() {

    //var puede cambiar--val no puede cambiar
    //Si una var puede admitir nulos se pone ? private var name:String? = null


   private val moviewFactory : MovieFactory = MovieFactory()
//Aqui android crea la actividad / como cuando java hace un new
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    //viewModel recibe los elementos de la vista. Activity avisa al view model que la vista se ha creado
    val viewModel = moviewFactory.buildViewModel()
    val movies =viewModel.viewCreated()
    Log.d("@dev", movies.toString())
    }
//metodos del ciclo de vida
    override fun onStart() { // el usuario ve la pantalla pero aun no puede interactuar con ella
        super.onStart()
    Log.d("@dev", "onStart")

    }

    override fun onResume() { // se visualiza la pantalla y el usuario ya puede interactuar con ella
        super.onResume()
        Log.d("@dev", "onResume")

    }

    //para parar LA PANTALLA onPause
    override fun onPause() {
        super.onPause()
        Log.d("@dev", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("@dev", "onStop")

    }
    //si pasa mucho rato en pause o queremos detener total onStop
    //para eliminar, detener bruto/ cuando deslizas app para arriba onDestroy()

}
