package edu.iesam.dam2024.features.movies.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movies = viewModel.viewCreated()
        bindData(movies)

        //testXml()
        //testListXml()

    }


    private fun bindData(movies: List<Movie>) {
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_title_1).text = movies[0].title
        val imageView1 = findViewById<ImageView>(R.id.imagen1)
        imageView1.loadUrl(movies[0].poster)
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
            navigateToMovieDetail(movies[0].id)

        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_title_2).text = movies[1].title
        val imageView2 = findViewById<ImageView>(R.id.imagen2)
        imageView2.loadUrl(movies[1].poster)
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_title_3).text = movies[2].title
        val imageView3 = findViewById<ImageView>(R.id.imagen3)
        imageView3.loadUrl(movies[2].poster)
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }


        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.serie_title_4).text = movies[3].title
        val imageView4 = findViewById<ImageView>(R.id.imagen4)
        imageView4.loadUrl(movies[3].poster)
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToMovieDetail(movies[3].id)
        }


    }
    private fun navigateToMovieDetail(movieId: String){
        startActivity(MovieDetailActivity.getIntent(this, movieId))
    }



}