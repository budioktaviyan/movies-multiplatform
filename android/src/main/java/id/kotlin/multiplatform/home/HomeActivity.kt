package id.kotlin.multiplatform.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.kotlin.multiplatform.R
import id.kotlin.multiplatform.data.MovieData
import id.kotlin.multiplatform.data.MovieRepository
import id.kotlin.multiplatform.data.Result
import id.kotlin.multiplatform.domain.Movie
import id.kotlin.multiplatform.presentation.MovieContract
import id.kotlin.multiplatform.presentation.MoviePresenter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), MovieContract.View {

    private val presenter: MoviePresenter = MoviePresenter(Movie(MovieRepository()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        presenter.initPresenter(this)
        presenter.showDiscoverMovie()
    }

    override fun onShowDiscoverMovie(data: MovieData) {
        val results: List<Result> = data.results
        val adapter = HomeAdapter(results = results)
        rv_home.adapter = adapter
    }
}