package edu.iesam.dam2024

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //TIENE CONSTRUCTOR POR DEFECTO Y DESPUES SE EJECUTARIA EL INIT Y DESPUES METODOS O CONSTRUCTORES DE DESPUES
    // NORMALMENTE NO USAREMOS EL INIT ASI QUE PARA DEFINIR UNA VARIABLE SIEMPRE HAY QUE DARLE VALOR AUN QUE SEA NULL
    //var puede cambiar--val no puede cambiar
    //Si una var puede admitir nulos se pone ? private var name:String? = null
    private var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name = "Alumno"
        //log.d imprime en logcat (simbolo de gato en barra de abajo a la izquierda)
        name?.let{ nameNotNull -> //nameNotNull renombra la variable it
            Log.d("@dev", nameNotNull)
           // Log.d("@dev", name) //hace referencia a name cuando es nulo
           // Log.d("@dev", it) //hace referencia a name cuando no es nulo

        }

    }
}