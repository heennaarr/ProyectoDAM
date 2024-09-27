package edu.iesam.dam2024.features.movies.presentation

import MovieMockRemoteDataSource
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository


//Es la parte cercana a la parte visual del usuario
class MovieActivity : AppCompatActivity() {

    private val movieRepository: MovieRepository = MovieDataRepository(MovieMockRemoteDataSource())
    private val movieFactory: MovieFactory = MovieFactory(movieRepository)
    private val viewModel: MovieViewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Llama a viewCreated para obtener la lista de películas
        val movies = viewModel.viewCreated()
        bindData(movies)
        Log.d("@dev", movies.toString()) // Log de las películas

        // Simula un clic en el primer elemento si hay películas

             textXml()
    }
    private fun bindData(movies:List<Movie>){
        //Cuando usamos bind lo que queremos es asignar datos a elementos de las vistas
        findViewById<TextView>(R.id.superhero_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        //R de recursos, eliges id y despues el id correspondiente, .text es una opcion que rellenas aqui para el layour
        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_title_4).text = movies[3].title

        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener{
            viewModel.itemSelected(movies[0].id)
            val movie1: Movie?  =viewModel.itemSelected(movies[0].id)
            movie1?.let {
                Log.d("@dev" , "Pelicula seleccionada: ${it.title}")
            }
        }


    }
    private fun textXml(){
        val xmlDataSource = MovieXmlLocalDataSource(this)
        val movie = viewModel.itemSelected("1")
        movie?.let{
            xmlDataSource.save(it)


        }
        val movieSaved = xmlDataSource.findMovie()
        Log.d("@dev", movieSaved.toString())
        xmlDataSource.delete()

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
