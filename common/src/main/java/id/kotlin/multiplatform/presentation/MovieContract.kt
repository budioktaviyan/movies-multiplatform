package id.kotlin.multiplatform.presentation

import id.kotlin.multiplatform.data.MovieData

interface MovieContract {

    interface View {

        fun onShowDiscoverMovie(data: MovieData)
    }

    interface Presenter {

        fun initPresenter(view: View)

        fun showDiscoverMovie()
    }
}