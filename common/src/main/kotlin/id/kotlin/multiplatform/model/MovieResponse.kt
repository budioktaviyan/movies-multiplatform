package id.kotlin.multiplatform.model

data class Data(val results: List<Result>, val totalPages: Long)
data class Result(val title: String, val overview: String, val posterPath: String, val backdropPath: String)