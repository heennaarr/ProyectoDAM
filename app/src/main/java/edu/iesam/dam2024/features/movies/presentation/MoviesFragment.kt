package edu.iesam.dam2024.features.movies.presentation

import MovieMockRemoteDataSource
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.Movie


class MoviesFragment: Fragment() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieViewModel

    private var _binding : FragmentMoviesBinding?=null
    private val binding get() = _binding!!
    private val adapter = MovieAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        setupView()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel= movieFactory.getMoviesListViewModel()
        setupObserver()
        viewModel.loadMovies()
    }
    private fun setupObserver() {
        val movieObserver = Observer<MovieViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
    private fun bindData(movies: List<Movie>) {

        adapter.setData(movies)

    }
    private fun setupView() {
        binding.apply {
            list.layoutManager = LinearLayoutManager(
                this@MoviesFragment.requireContext(),
                LinearLayoutManager.VERTICAL,
                false

            )
            list.adapter = adapter

        }
    }



    private fun showError(error: ErrorApp){
        when(error){
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp -> TODO()
            ErrorApp.UnknowErrorApp -> TODO()
            ErrorApp.TestErrorApp -> TODO()
        }
    }
    private fun navigateToMovieDetail(movieId: String){
        findNavController().navigate(MoviesFragmentDirections.actionMovieFragmentToMovieFragmentDetail(movieId))
    }

        override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}