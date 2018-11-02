import Foundation

open class Datasource: NSObject {

    open var objects: [Any]?

    open func cellClasses() -> [DatasourceCell.Type] {
        return []
    }

    open func cellClass(_ indexPath: IndexPath) -> DatasourceCell.Type? {
        return nil
    }

    open func headerClasses() -> [DatasourceCell.Type]? {
        return []
    }

    open func footerClasses() -> [DatasourceCell.Type]? {
        return []
    }

    open func numberOfItems(_ section: Int) -> Int {
        return objects?.count ?? 0
    }

    open func numberOfSections() -> Int {
        return 1
    }

    open func item(_ indexPath: IndexPath) -> Any? {
        return objects?[indexPath.item]
    }

    open func headerItem(_ section: Int) -> Any? {
        return nil
    }

    open func footerItem(_ section: Int) -> Any? {
        return nil
    }
}
