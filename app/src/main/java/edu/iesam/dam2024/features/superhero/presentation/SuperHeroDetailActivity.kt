package edu.iesam.dam2024.features.superhero.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView

import androidx.appcompat.app.AppCompatActivity

import com.bumptech.glide.Glide
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie
class MovieDetailActivity : AppCompatActivity() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_super_hero_detail)
        superHeroFactory = SuperHeroFactory(this)
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()
        getSuperHeroId()?.let { superheroId ->
            viewModel.viewCreated(superheroId)?.let { movie ->
                bindData(movie)
            }
        }
    }
    private fun getSuperHeroId(): String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }
    private fun bindData(movie: Movie) {
        val imageView = findViewById<ImageView>(R.id.poster)
        Glide
            .with(this)
            .load(movie.poster)
            .into(imageView)
    }
    companion object {
        val KEY_MOVIE_ID = "key_movie_id"
        fun getIntent(context: Context, movieId: String): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(KEY_MOVIE_ID, movieId)
            return intent
        }
    }
}