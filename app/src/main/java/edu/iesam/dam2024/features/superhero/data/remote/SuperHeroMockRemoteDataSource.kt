import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superhero.domain.SuperHero
import edu.iesam.dam2024.features.superhero.domain.SuperHeroRepository

class SuperHeroMockRemoteDataSource {
    private val superheroes= listOf(
        SuperHero(id = "1", alias = "Spiderman", nombre = "Spidey", superPoder = "Trepar paredes y lanzar telarañas", años = 24, ocupacion = "Fotógrafo", lugarDeNacimiento = "Nueva York", publisher = "Marvel Comics", imagen = "https://upload.wikimedia.org/wikipedia/commons/5/52/Spider-Man.jpg"),
        SuperHero(id = "2", alias = "Batman", nombre = "El Caballero Oscuro", superPoder = "Inteligencia y habilidades de combate", años = 30, ocupacion = "Empresario", lugarDeNacimiento = "Gotham City", publisher = "DC Comics", imagen = "https://img.rtve.es/imagenes/batman-actores-cine-saber-ganar/1634549481092.jpg"),
        SuperHero(id = "3", alias = "Hulk", nombre = "Bruce Banner", superPoder = "Fuerza sobrehumana", años = 14, ocupacion = "Científico", lugarDeNacimiento = "Dayton, Ohio", publisher = "Marvel Comics", imagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Hulk_%282540708438%29.jpg/1200px-Hulk_%282540708438%29.jpg"),
        SuperHero(id = "4", alias = "Superman", nombre = "El Hombre de Acero", superPoder = "Superfuerza, velocidad y vuelo", años = 85, ocupacion = "Reportero", lugarDeNacimiento = "Krypton", publisher = "DC Comics", imagen = "https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2022/08/03/16595421832009.jpg")


    )


    fun getSuperheroes(): List<SuperHero> {
        return superheroes
    }

    fun getSuperHeroSelected(superHeroId:String): SuperHero?{
        return superheroes.firstOrNull{it.id ==superHeroId}
    }
}