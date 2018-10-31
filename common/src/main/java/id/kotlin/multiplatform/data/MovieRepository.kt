package id.kotlin.multiplatform.data

import id.kotlin.multiplatform.Configs
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTreeParser
import kotlinx.serialization.json.content

class MovieRepository {

    fun parse(response: String): Data {
        val element: JsonObject = JsonTreeParser(response).read() as? JsonObject
                  ?: return Data(results = emptyList(), totalPages = 0)
        val totalPages: Long = element["total_pages"].content.toLong()
        val results: List<Result> = element["results"].jsonArray.map {
            val json: JsonObject = it.jsonObject
            val poster = json["poster_path"].content
            val backdrop = json["backdrop_path"].content

            Result(
                    title = json["title"].content,
                    overview = json["overview"].content,
                    posterPath = "${Configs.IMAGE_URL}/$poster",
                    backdropPath = "${Configs.IMAGE_URL}/$backdrop"
            )
        }

        return Data(results = results, totalPages = totalPages)
    }
}