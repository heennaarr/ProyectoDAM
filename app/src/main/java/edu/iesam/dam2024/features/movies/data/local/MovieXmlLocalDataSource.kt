package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

//Context es la primera clase, todas las actividades son contexto. Es la clase padre del padre del padre del padre...de activity
class MovieXmlLocalDataSource(private val context: Context) {

    private val sharedPref= context.getSharedPreferences(
        context.getString(R.string.name_file_xml), Context.MODE_PRIVATE)

    fun save(movie:Movie) { //guardar


        sharedPref.edit().apply{
            putString("id", movie.id)
            putString("title", movie.title)
            putString("poster", movie.poster)
            apply()
        }

    }

    fun findMovie(): Movie {//recupera /lee
        //SE USA LA LIBRERIA GSON -> HACE QUE UN MODELO LO PASA A JSON, LA G ES POR QUE LO HA HECHO GOOGLE
       sharedPref.apply {
           val id =getString("id" , "")
           val title = getString("title" , "")
           val poster = getString("poster" , "")
          return  Movie(
              getString("id" , "")!!,
               getString("title" , "") !!,
               getString("poster" , "")!! )
       }





    }
    fun delete(){
        sharedPref.edit().clear().apply()//elimina el fichero xml
    }
}