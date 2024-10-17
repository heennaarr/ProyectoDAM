package edu.iesam.dam2024.features.movies.domain
import kotlinx.serialization.Serializable
//El constructor principal está entre los parentesis despues de definir la clase
@Serializable
//El constructor principal está entre los parentesis despues de definir la clase
data class Movie(val id:String, val title: String, val poster:String, val description:String, val year: String, val ageMin:String, val duration:String) {
}