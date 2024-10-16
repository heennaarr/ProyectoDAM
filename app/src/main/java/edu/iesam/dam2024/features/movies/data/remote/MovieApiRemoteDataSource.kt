import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import android.util.Log
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

class MovieApiRemoteDataSource {

    suspend fun buildClient() {
        val client = HttpClient(CIO)

        try {
            // Realiza la petición HTTP
            val response: HttpResponse = client.get("http://10.0.2.2:8080/tasks")

            // Log para el estado de la respuesta
            Log.d("@dev", "Response status: ${response.status}")
            // Asegúrate de obtener el cuerpo de la respuesta como texto
            val responseBody = response.bodyAsText()
            Log.d(
                "@dev",
                "Response body: $responseBody"
            ) // Imprime el contenido antes de deserializar
            // Deserializa el JSON en una lista de objetos Task
            val tasks: List<Task> = Json.decodeFromString(responseBody)
            // Log para verificar los objetos deserializados
            tasks.forEach {
                Log.d("@dev", "Task title: ${it.title}")
            }

        } catch (e: Exception) {
            // Manejo de errores
            Log.e("@dev", "Error en la solicitud HTTP: ${e.message}", e)

        } finally {
            // Cierra el cliente HTTP
            client.close()
        }
    }
}


data class Task(val title: String)
