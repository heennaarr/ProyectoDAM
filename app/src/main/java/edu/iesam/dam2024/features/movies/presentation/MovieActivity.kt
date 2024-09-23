package edu.iesam.dam2024.features.movies.presentation

import MovieMockRemoteDataSource
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.domain.MovieRepository


//Es la parte cercana a la parte visual del usuario
class MovieActivity : AppCompatActivity() {

    private val movieRepository: MovieRepository = MovieDataRepository(MovieMockRemoteDataSource())
   a private val movieFactory: MovieFactory = MovieFactory(movieRepository)
    private val viewModel: MovieViewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llama a viewCreated para obtener la lista de películas
        val movies = viewModel.viewCreated()
        Log.d("@dev", movies.toString()) // Log de las películas

        // Simula un clic en el primer elemento si hay películas

            val selectedMovie = viewModel.itemSelected(movies.first().id)
            Log.d("@dev", "Selected movie: $selectedMovie") // Log de la película seleccionada

    }


//metodos del ciclo de vida
   /** override fun onStart() { // el usuario ve la pantalla pero aun no puede interactuar con ella
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

    }**/
    //si pasa mucho rato en pause o queremos detener total onStop
    //para eliminar, detener bruto/ cuando deslizas app para arriba onDestroy()

}
