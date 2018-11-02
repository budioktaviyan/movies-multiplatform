import UIKit
import KotlinCommon

class HomeController: DatasourceController {

    private lazy var presenter: MoviePresenter = MoviePresenter(movie: Movie(repository: MovieRepository()))
    private lazy var datasources: HomeDatasource = HomeDatasource()

    override func viewDidLoad() {
        self.title = "Movie"
        self.collectionView?.backgroundColor = .white
        self.datasource = datasources
        self.presenter.doInitPresenter(view: self)
        self.presenter.showDiscoverMovie()
    }

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 0
    }

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 4
    }

    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
        return UIEdgeInsets(top: 4, left: 4, bottom: 4, right: 4)
    }

    override func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: view.frame.width / 2 - 7.5, height: 256)
    }
}

extension HomeController: MovieContractView {

    func onShowDiscoverMovie(data: MovieData) {
        datasources.objects = data.results
        collectionView.reloadData()
    }
}
