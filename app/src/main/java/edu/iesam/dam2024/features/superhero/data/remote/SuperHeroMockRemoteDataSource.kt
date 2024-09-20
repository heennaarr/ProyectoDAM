import edu.iesam.dam2024.features.superhero.domain.SuperHero

class SuperHeroMockRemoteDataSource {
    fun getSuperheroes(): List<SuperHero>{
        return listOf(
            SuperHero("Spiderman", "Saltar" , 24),
            SuperHero("Batman", "Volar" , 20),
            SuperHero("Hulk", "Fuerza" , 14),
            SuperHero(nombre="henar" , años=21, superPoder = "Invisibilidad")
        )

    }
}