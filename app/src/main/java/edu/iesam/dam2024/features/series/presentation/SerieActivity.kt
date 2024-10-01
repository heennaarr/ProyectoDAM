package edu.iesam.dam2024.features.series.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.presentation.MovieFactory
import edu.iesam.dam2024.features.movies.presentation.MovieViewModel

class SerieActivity : AppCompatActivity() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}