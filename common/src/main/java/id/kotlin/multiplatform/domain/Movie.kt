package id.kotlin.multiplatform.domain

import id.kotlin.multiplatform.data.Data
import id.kotlin.multiplatform.data.MovieRepository

class Movie(private val repository: MovieRepository) {

    fun run(response: String): Data = repository.parse(response)
}