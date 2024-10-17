import io.ktor.client.request.*
import android.util.Log
import edu.iesam.dam2024.features.movies.domain.Movie
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class MovieApiRemoteDataSource {

    suspend fun buildClient(): List<Movie> {
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
}
