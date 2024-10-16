package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonDetailBinding
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonDetailFragment:Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonDetailViewModel

    private var _binding : FragmentPokemonDetailBinding?=null
    private val binding get() = _binding!!

    private val pokemonArgs: PokemonDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater,container,false)
        return binding.root
    }
    private fun setupObserver() {
        val pokemonObserver = Observer<PokemonDetailViewModel.UiState> { uiState ->
            uiState.pokemon?.let {
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
        viewModel.uiState.observe(viewLifecycleOwner, pokemonObserver)


    }
    private fun bindData(pokemon: Pokemon) {
        val imageView = binding.imagen
        imageView.loadUrl(pokemon.imagen)
        binding.nombre.text = pokemon.nombre
        binding.tipo.text = pokemon.type


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      pokemonFactory= PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildPokemonDetailViewModel()
        setupObserver()
        pokemonArgs.pokemonId
        viewModel.viewCreated(pokemonArgs.pokemonId)





    }

}