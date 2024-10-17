import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class MovieDataRepository(
    private val mockRemoteDataSource: MovieApiRemoteDataSource,
    private val local: MovieXmlLocalDataSource
): MovieRepository {

    // Hacemos la función suspend
    override suspend fun getMovies(): List<Movie> {
        val movieFromLocal = local.findAll()
        return if (movieFromLocal.isEmpty()) {
            // Usamos withContext para llamar al método suspend
            val moviesFromRemote = withContext(Dispatchers.IO) {
                mockRemoteDataSource.buildClient()
            }
            local.saveAll(moviesFromRemote)
            moviesFromRemote
        } else {
            movieFromLocal
        }
    }

    override suspend fun getMovie(movieId: String): Movie? {
        // Primero intentamos buscar la película localmente
        val movieFromLocal = local.findById(movieId)

        return if (movieFromLocal != null) {
            // Si existe en local, la devolvemos
            movieFromLocal
        } else {
            // Si no está en local, la buscamos en el servidor remoto
            val movieFromRemote = withContext(Dispatchers.IO) {
                mockRemoteDataSource.buildClientOneMovie(movieId)
            }
            // Guardamos la película obtenida en el almacenamiento local
            local.save(movieFromRemote)
            movieFromRemote
        }
    }
}
