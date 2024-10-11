import edu.iesam.dam2024.features.movies.domain.Movie


/**
 * Naming: Modelo + Tecnología + RemoteDataSource
 * **/
class MovieMockRemoteDataSource {

    private val movies = listOf(
        Movie("1", "Avatar", "https://static.posters.cz/image/750/posters/avatar-limited-ed-couple-i7199.jpg" , "esta es la descripcion de la  pelicula 1" , "2034", "+23", "1h 30"),
        Movie("2", "Un puente hacia terabithia", "https://pics.filmaffinity.com/Un_puente_hacia_Terabithia-349890819-large.jpg", "esta es la descripcion de la pelicula 2", "2034", "+23", "1h 30"),
        Movie("3", "Inside Out", "https://pics.filmaffinity.com/Del_revaes_Inside_Out-161470323-large.jpg","", "2034", "+23", "1h 30"),
        Movie(title = "Las cronicas de Spiderwich", poster = "https://m.media-amazon.com/images/I/516bIaE1boL._AC_UF894,1000_QL80_.jpg", id = "4", description = "", year = "2034", ageMin = "+23", duration = "1h 30")
    )

    fun getMovies(): List<Movie> {
        return movies
    }

    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { it.id == movieId }
    }
}