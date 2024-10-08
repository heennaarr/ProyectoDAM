package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailFragment: Fragment() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding : FragmentMoviesBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun setupObserver() {
        val movieObserver = Observer<MovieDetailViewModel.UiState> { uiState ->
            uiState.movie?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(this, movieObserver)


    }
    private fun bindData(movie: Movie) {
        val imageView = binding.poster
        imageView.loadUrl(movie.poster)
        Log.d("poster" , movie.poster)
        findViewById<TextView>(R.id.titleMovie).text=movie.title
        findViewById<TextView>(R.id.descriptionMovie).text = movie.description
        findViewById<TextView>(R.id.year).text = movie.year
        findViewById<TextView>(R.id.ageMin).text =  movie.ageMin
        findViewById<TextView>(R.id.duration).text = movie.duration



    }

}