package id.kotlin.multiplatform

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.kotlin.multiplatform.data.Data
import id.kotlin.multiplatform.data.MovieRepository
import id.kotlin.multiplatform.domain.Movie
import id.kotlin.multiplatform.presentation.MovieContract
import id.kotlin.multiplatform.presentation.MoviePresenter

class HomeActivity : AppCompatActivity(), MovieContract.View {

    private val presenter: MoviePresenter = MoviePresenter(Movie(MovieRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.initPresenter(this)
        presenter.showDiscoverMovie()
    }

    override fun onShowDiscoverMovie(data: Data) {}
}