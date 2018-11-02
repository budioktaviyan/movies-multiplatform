package id.kotlin.multiplatform.data

data class MovieData(val results: List<Result>, val totalPages: Long)
data class Result(val title: String, val overview: String, val posterPath: String, val backdropPath: String)