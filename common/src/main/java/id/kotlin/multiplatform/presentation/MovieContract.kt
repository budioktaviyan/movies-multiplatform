package id.kotlin.multiplatform.presentation

import id.kotlin.multiplatform.data.Data

interface MovieContract {

    interface View {

        fun onShowDiscoverMovie(data: Data)
    }

    interface Presenter {

        fun initPresenter(view: View)

        fun showDiscoverMovie()
    }
}