import UIKit

class HomeDatasource: Datasource {

    override func numberOfItems(_ section: Int) -> Int {
        return objects?.count ?? 0
    }

    override func item(_ indexPath: IndexPath) -> Any? {
        return objects?[indexPath.item]
    }

    override func cellClasses() -> [DatasourceCell.Type] {
        return [HomeCell.self]
    }

    override func cellClass(_ indexPath: IndexPath) -> DatasourceCell.Type? {
        return HomeCell.self
    }
}
