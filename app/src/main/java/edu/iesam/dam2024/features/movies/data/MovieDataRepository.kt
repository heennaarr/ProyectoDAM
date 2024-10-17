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

    override fun getMovie(movieId: String): Movie? {
        TODO("Not yet implemented")
    }
}
