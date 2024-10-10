package edu.iesam.dam2024.features.superhero.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import edu.iesam.dam2024.databinding.FragmentSuperheroDetailBinding
import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroDetailFragment : Fragment() {
    private lateinit var superHeroFactory: SuperHeroFactory
    private lateinit var viewModel: SuperHeroDetailViewModel

    private var _binding: FragmentSuperheroDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSuperheroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupObserver() {
        val superheroObserver = Observer<SuperHeroDetailViewModel.UiState> { uiState ->
            uiState.superhero?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                // Manejar el error aquí
                Log.e("@dev", "Error: ${uiState.errorApp}")
            }
            if (uiState.isLoading) {
                Log.d("@dev", "Cargando...")
            } else {
                Log.d("@dev", "Cargado ...")
            }
        }
        viewModel.uiState.observe(viewLifecycleOwner, superheroObserver)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        superHeroFactory = SuperHeroFactory(requireContext())
        viewModel = superHeroFactory.buildSuperHeroDetailViewModel()
        setupObserver()
        /*getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)
        }*/

    }




    private fun bindData(superHero: SuperHero) {

    }


}
