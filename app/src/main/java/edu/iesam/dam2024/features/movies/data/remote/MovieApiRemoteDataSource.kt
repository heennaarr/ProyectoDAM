import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import android.util.Log
import edu.iesam.dam2024.features.movies.domain.Movie
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json

class MovieApiRemoteDataSource {

    suspend fun buildClient() {
        val client = HttpClient(CIO){
            install(ContentNegotiation) {
                json()
            }
        }

            // Realiza la petición HTTP
            val response: List<Movie> = client.get("http://10.0.2.2:8080/tasks").body()

            Log.d("@dev", response.toString())




    }
}



