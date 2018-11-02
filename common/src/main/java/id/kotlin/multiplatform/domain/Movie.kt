package id.kotlin.multiplatform.domain

import id.kotlin.multiplatform.data.MovieData
import id.kotlin.multiplatform.data.MovieRepository

class Movie(private val repository: MovieRepository) {

    fun run(response: String): MovieData = repository.parse(response)
}