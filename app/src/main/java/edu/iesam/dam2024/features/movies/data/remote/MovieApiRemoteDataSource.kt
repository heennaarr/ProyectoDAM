import io.ktor.client.request.*
import android.util.Log
import edu.iesam.dam2024.features.movies.data.remote.MovieService
import edu.iesam.dam2024.features.movies.domain.Movie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class MovieApiRemoteDataSource(private val movieService: MovieService){

   /* suspend fun buildClient(): List<Movie> {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
        // Realiza la petición HTTP
        val response: List<Movie> = client.get("http://10.0.2.2:8080/tasks").body()
        Log.d("@dev", response.toString())
        return response
    }
    suspend fun buildClientOneMovie(movieId: String): Movie {
        val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
        // Realiza la petición HTTP con el movieId dinámico
        val response: Movie = client.get("http://10.0.2.2:8080/tasks/$movieId").body()
        Log.d("@dev", response.toString())
        return response
    }
    ktor
*/
   suspend fun buildClient(): List<Movie> {
        //isSuccessful te dice que si ha ido  bien
        movieService.requestMovies().body()!!
        return emptyList()
   }

    suspend fun buildClientOneMovie(movieId: String): Movie {
        //isSuccessful te dice que si ha ido  bien
        movieService.requestMovies().body()
        return Movie("","","","","","","")

    }
}
