package edu.iesam.dam2024.features.series.presentation

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.series.domain.Serie

class SerieActivity : AppCompatActivity() {
    private lateinit var serieFactory: SerieFactory
    private lateinit var viewModel : SerieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_serie)

        serieFactory = SerieFactory(this)
        viewModel = serieFactory.buildViewModel()

        val series = viewModel.viewCreated()
        bindData(series)
        Log.d("@dev", series.toString())
    }

    private fun bindData(series: List<Serie>) {
        findViewById<TextView>(R.id.serie_nombre_1).text = series[0].nombre
        findViewById<TextView>(R.id.serie_director_1).text = series[0].director

        findViewById<TextView>(R.id.serie_nombre_2).text = series[1].nombre
        findViewById<TextView>(R.id.serie_director_2).text = series[1].director

        findViewById<TextView>(R.id.serie_nombre_3).text = series[2].nombre
        findViewById<TextView>(R.id.serie_director_3).text = series[2].director

        findViewById<TextView>(R.id.serie_nombre_4).text = series[3].nombre
        findViewById<TextView>(R.id.serie_director_4).text = series[3].director


    }


}