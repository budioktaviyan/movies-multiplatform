package id.kotlin.multiplatform.domain

import id.kotlin.multiplatform.data.MovieRepository
import id.kotlin.multiplatform.model.Data

class Movie(private val repository: MovieRepository) {

    fun run(callback: (Data) -> Unit) = repository.getDiscoverMovie(callback)
}