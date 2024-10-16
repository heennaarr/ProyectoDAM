package edu.iesam.dam2024.features.pokemon.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.FragmentPokemonBinding
import edu.iesam.dam2024.features.pokemon.domain.ErrorApp
import edu.iesam.dam2024.features.pokemon.domain.Pokemon

class PokemonFragment: Fragment() {
    private lateinit var pokemonFactory: PokemonFactory
    private lateinit var viewModel: PokemonViewModel

    private var _binding : FragmentPokemonBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pokemonFactory = PokemonFactory(requireContext())
        viewModel = pokemonFactory.buildPokemonListViewModel()
        setupObserver()
        viewModel.loadPokemons()

    }
    private fun setupObserver() {
        val pokemonObserver = Observer<PokemonViewModel.UiState> { uiState ->
            uiState.pokemons?.let {
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
    private fun bindData(pokemons: List<Pokemon>) {
        binding.pokemonId1.text = pokemons[0].id
        binding.pokemonNombre1.text = pokemons[0].nombre
        val imageView1 = binding.imagen1

        imageView1.loadUrl(pokemons[0].imagen)
        binding.layout1.setOnClickListener {
            navigateToPokemonDetail(pokemons[0].id)
        }

        binding.pokemonId2.text = pokemons[1].id
        binding.pokemonNombre2.text = pokemons[1].nombre
        val imageView2 = binding.imagen2
        imageView2.loadUrl(pokemons[1].imagen)
        binding.layout2.setOnClickListener {
            navigateToPokemonDetail(pokemons[1].id)
        }

        binding.pokemonId3.text = pokemons[2].id
        binding.pokemonNombre3.text = pokemons[2].nombre
        val imageView3 = binding.imagen3
        imageView3.loadUrl(pokemons[2].imagen)
        binding.layout3.setOnClickListener {
            navigateToPokemonDetail(pokemons[2].id)
        }



    }
    private fun navigateToPokemonDetail(pokemonId: String){
        findNavController().navigate(PokemonFragmentDirections.actionPokemonFragmentToPokemonFragmentDetail(pokemonId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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


}