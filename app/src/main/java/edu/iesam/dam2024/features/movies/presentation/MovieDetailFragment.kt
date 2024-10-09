package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMoviesDetailBinding
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.presentation.MovieDetailActivity.Companion.KEY_MOVIE_ID

class MovieDetailFragment: Fragment() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MovieDetailViewModel

    private var _binding : FragmentMoviesDetailBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesDetailBinding.inflate(inflater,container,false)
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
        viewModel.uiState.observe(viewLifecycleOwner, movieObserver)


    }
    private fun bindData(movie: Movie) {
        val imageView = binding.poster
        imageView.loadUrl(movie.poster)
        binding.titleMovie.text=movie.title
        binding.descriptionMovie.text = movie.description
        binding.year.text = movie.year
        binding.ageMin.text =  movie.ageMin
        binding.duration.text = movie.duration



    }
  /*  private fun getMovieId(): String? {
      //  return intent.getStringExtra(KEY_MOVIE_ID)
    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        movieFactory = MovieFactory(requireContext())
        viewModel = movieFactory.buildMovieDetailViewModel()
        /*getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)
        }*/

    }

}