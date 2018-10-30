package id.kotlin.multiplatform.data

import id.kotlin.multiplatform.ApplicationDispatcher
import id.kotlin.multiplatform.model.Data
import id.kotlin.multiplatform.model.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import kotlinx.coroutines.experimental.launch
import kotlinx.serialization.json.JsonTreeParser

object ApiConfigs {

    const val API_KEY = "f920accbb779fcb3ab3bbec9a8b40bd0"
    const val BASE_URL = "https://api.themoviedb.org/3"
    const val IMAGE_URL = "https://image.tmdb.org/t/p/original"
}

class MovieRepository {

    private val client = HttpClient()

    fun getDiscoverMovie(callback: (Data) -> Unit) {
        launch(ApplicationDispatcher) {
            val result = discoverMovie()
            callback(parseResult(result))
        }
    }

    private suspend fun discoverMovie(): String {
        return client.get {
            url {
                protocol = URLProtocol.HTTPS
                host = ApiConfigs.BASE_URL
                port = URLProtocol.HTTPS.defaultPort
                encodedPath = "/discover/movie"
            }
        }
    }

    private fun parseResult(result: String): Data {
        val element = JsonTreeParser(result).read()
        val totalPages = element.jsonObject["total_pages"].primitive.content
        val results = element.jsonArray.map {
            Result(
                    title = it.jsonObject["title"].primitive.content,
                    overview = it.jsonObject["overview"].primitive.content,
                    posterPath = it.jsonObject["poster_path"].primitive.content,
                    backdropPath = it.jsonObject["backdrop_path"].primitive.content
            )
        }

        return Data(results = results, totalPages = totalPages.toLong())
    }
}