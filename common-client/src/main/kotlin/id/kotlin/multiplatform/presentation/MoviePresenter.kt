package id.kotlin.multiplatform.presentation

import id.kotlin.multiplatform.UIDispatcher
import id.kotlin.multiplatform.domain.Movie
import id.kotlin.multiplatform.model.Data
import id.kotlin.multiplatform.presentation.MovieContract.View
import kotlinx.coroutines.experimental.launch

class MoviePresenter(private val movie: Movie) : MovieContract.Presenter {

    private lateinit var view: MovieContract.View
    private lateinit var data: Data

    override fun initPresenter(view: View) {
        this.view = view
    }

    override fun showDiscoverMovie() {
        movie.run {
            data = Data(it.results, it.totalPages)
            launch(UIDispatcher) { view.onShowDiscoverMovie(data) }
        }
    }
}