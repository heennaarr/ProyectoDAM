package edu.iesam.dam2024.features.movies.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.ViewMoviesItemBinding
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    private lateinit var binding: ViewMoviesItemBinding


    fun bind(movie:Movie){
        binding= ViewMoviesItemBinding.bind(view)

        binding.apply {
            image.loadUrl(movie.poster)
            name.text=movie.title
            descripcion.text=movie.description


        }





    }

}