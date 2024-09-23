package edu.iesam.dam2024.features.superhero.domain

data class SuperHero(
    val id: Int,
    val nombre: String,
    val alias: String,
    val superPoder: String,
    val años: Int,
    val ocupacion: String,
    val lugarDeNacimiento: String,
    val publisher: String,
    val imagen: String
)


