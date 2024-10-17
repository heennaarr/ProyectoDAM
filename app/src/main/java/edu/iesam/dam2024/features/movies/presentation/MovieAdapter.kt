package edu.iesam.dam2024.features.movies.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    private val dataList : MutableList<Movie> = mutableListOf()

    fun setData(movies: List<Movie>){
        dataList.clear()
        addData(movies)

    }
    fun addData(movies: List<Movie>){
        dataList.addAll(movies)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.view_movies_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}