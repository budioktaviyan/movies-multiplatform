import UIKit
import KotlinCommon

class ViewController: UIViewController, MovieContractView {

    private let presenter: MoviePresenter = MoviePresenter(movie: Movie(repository: MovieRepository()))

    override func viewDidLoad() {
        super.viewDidLoad()
        title = "Movie"
        view.backgroundColor = .white
        presenter.doInitPresenter(view: self)
        presenter.showDiscoverMovie()
    }

    func onShowDiscoverMovie(data: MovieData) {
        _ = data.results.compactMap {
            print("Title: \($0.title)")
            print("Poster: \($0.posterPath)")
            print("Backdrop: \($0.backdropPath)")
        }
        print("Total Pages: \(data.totalPages)")
    }
}
