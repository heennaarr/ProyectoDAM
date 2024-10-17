package edu.iesam.dam2024.features.movies.presentation

import MovieApiRemoteDataSource
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentMoviesBinding
import edu.iesam.dam2024.features.movies.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.Movie
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MoviesFragment: Fragment() {
    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel : MovieViewModel

    private var _binding : FragmentMoviesBinding?=null
    private val binding get() = _binding!!

    //testing
    private val movieApiRemoteDataSource = MovieApiRemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFactory = MovieFactory(requireContext())
        viewModel= movieFactory.getMoviesListViewModel()
        setupObserver()
        viewModel.loadMovies()
        GlobalScope.launch {
            movieApiRemoteDataSource.buildClient()
        }
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

        binding.movieId1.text= movies[0].id
        binding.movieTitle1.text =movies[0].title
        val imageView1 = binding.imagen1
        imageView1.loadUrl(movies[0].poster)
       binding.layout1.setOnClickListener {
           navigateToMovieDetail(movies[0].id)

        }

        binding.movieId2.text=  movies[1].id
        binding.movieTitle2.text =movies[1].title
        val imageView2 = binding.imagen2
        imageView2.loadUrl(movies[1].poster)
        binding.layout2.setOnClickListener {
            navigateToMovieDetail(movies[1].id)
        }

        binding.movieId3.text=  movies[2].id
        binding.movieTitle3.text =movies[2].title
        val imageView3 = binding.imagen3
        imageView3.loadUrl(movies[2].poster)
        binding.layout3.setOnClickListener {
            navigateToMovieDetail(movies[2].id)
        }


        binding.movieId4.text=  movies[3].id
        binding.movieTitle4.text= movies[3].title
        val imageView4 = binding.imagen4
        imageView4.loadUrl(movies[3].poster)
        binding.layout4.setOnClickListener {
            navigateToMovieDetail(movies[3].id)
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