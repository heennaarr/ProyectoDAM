package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

//Context es la primera clase, todas las actividades son contexto. Es la clase padre del padre del padre del padre...de activity
class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref= context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE)

    fun save(movie:Movie) {
        val editor = sharedPref.edit()
        editor.putString("id", movie.id)
        editor.putString("title", movie.title)
        editor.putString("poster", movie.poster)
        editor.apply() //edit.commit()
    }

}