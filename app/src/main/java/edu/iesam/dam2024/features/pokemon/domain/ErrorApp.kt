package edu.iesam.dam2024.features.pokemon.domain

sealed class ErrorApp {
    object InternetErrorApp:ErrorApp()
    object ServerErrorApp:ErrorApp()
    object DataErrorApp:ErrorApp()
    object UnknowErrorApp:ErrorApp()
    object TestErrorApp:ErrorApp()
}