import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroMockRemoteDataSource {
    val  api = "https://akabab.github.io/superhero-api/api/all.json"
    private val superheroes= listOf(
            SuperHero(id = "1", nombre = "Spiderman", alias = "Spidey", superPoder = "Trepar paredes", años = 24, ocupacion = "Fotógrafo", lugarDeNacimiento = "Nueva York", publisher = "Marvel Comics", imagen = "url_de_imagen"),
            SuperHero(id = "2", nombre = "Batman", alias = "El Caballero Oscuro", superPoder = "Inteligencia y habilidades de combate", años = 30, ocupacion = "Empresario", lugarDeNacimiento = "Gotham City", publisher = "DC Comics", imagen = "url_de_imagen"),
            SuperHero(id = "3", nombre = "Hulk", alias = "Bruce Banner", superPoder = "Fuerza sobrehumana", años = 14, ocupacion = "Científico", lugarDeNacimiento = "Dayton, Ohio", publisher = "Marvel Comics", imagen = "url_de_imagen"),
            SuperHero(id = "4", nombre = "Henar", alias = "N/A", superPoder = "Invisibilidad", años = 21, ocupacion = "N/A", lugarDeNacimiento = "N/A", publisher = "N/A", imagen = "url_de_imagen")


        )


    fun getSuperheroes(): List<SuperHero> {
        return superheroes
    }

    fun getSuperHeroSelected(superHeroId:String): SuperHero?{
        return superheroes.firstOrNull{it.id ==superHeroId}
    }
}