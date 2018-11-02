import UIKit

open class DatasourceController: UICollectionViewController, UICollectionViewDelegateFlowLayout {

    open var datasource: Datasource? {
        didSet {
            guard let headerClasses = datasource?.headerClasses() else { return }
            let _ = headerClasses.compactMap { headerClass in
                collectionView?.register(
                    headerClass,
                    forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader,
                    withReuseIdentifier: NSStringFromClass(headerClass)
                )
            }

            guard let cellClasses = datasource?.cellClasses() else { return }
            let _ = cellClasses.compactMap { cellClass in
                collectionView?.register(
                    cellClass,
                    forCellWithReuseIdentifier: NSStringFromClass(cellClass)
                )
            }

            guard let footerClasses = datasource?.footerClasses() else { return }
            let _ = footerClasses.compactMap { footerClass in
                collectionView?.register(
                    footerClass,
                    forSupplementaryViewOfKind: UICollectionView.elementKindSectionFooter,
                    withReuseIdentifier: NSStringFromClass(footerClass)
                )
            }

            collectionView?.reloadData()
        }
    }

    open var layout: UICollectionViewFlowLayout? {
        get { return collectionViewLayout as? UICollectionViewFlowLayout }
    }

    let defaultHeaderId: String = "defaultHeaderId"
    let defaultCellId: String = "defaultCellId"
    let defaultFooterId: String = "defaultFooterId"

    public init() {
        super.init(collectionViewLayout: UICollectionViewFlowLayout())
    }

    public required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    override open func viewDidLoad() {
        collectionView?.backgroundColor = .white
        collectionView?.alwaysBounceVertical = true

        collectionView?.register(
            DefaultHeader.self,
            forSupplementaryViewOfKind: UICollectionView.elementKindSectionHeader,
            withReuseIdentifier: defaultHeaderId
        )

        collectionView?.register(
            DefaultCell.self,
            forCellWithReuseIdentifier: defaultCellId
        )

        collectionView?.register(
            DefaultFooter.self,
            forSupplementaryViewOfKind: UICollectionView.elementKindSectionFooter,
            withReuseIdentifier: defaultFooterId
        )
    }

    override open func numberOfSections(in collectionView: UICollectionView) -> Int {
        return datasource?.numberOfSections() ?? 1
    }

    override open func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return datasource?.numberOfItems(section) ?? 0
    }

    override open func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell: DatasourceCell
        if let clazz = datasource?.cellClass(indexPath) {
            cell = collectionView.dequeueReusableCell(withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
        } else if let classes = datasource?.cellClasses(), classes.count > indexPath.section {
            let clazz = classes[indexPath.section]
            cell = collectionView.dequeueReusableCell(withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
        } else if let clazz = datasource?.cellClasses().first {
            cell = collectionView.dequeueReusableCell(withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
        } else {
            cell = collectionView.dequeueReusableCell(withReuseIdentifier: defaultCellId, for: indexPath) as! DatasourceCell
        }

        cell.controller = self
        cell.datasource = datasource?.item(indexPath)

        return cell
    }

    override open func collectionView(_ collectionView: UICollectionView, viewForSupplementaryElementOfKind kind: String, at indexPath: IndexPath) -> UICollectionReusableView {
        let cell: DatasourceCell
        switch kind {
        case UICollectionView.elementKindSectionHeader:
            if let classes = datasource?.headerClasses(), classes.count > indexPath.section {
                let clazz = classes[indexPath.section]
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
            } else if let clazz = datasource?.headerClasses()?.first {
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
            } else {
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: defaultHeaderId, for: indexPath) as! DatasourceCell
            }

            cell.datasource = datasource?.headerItem(indexPath.section)
        default:
            if let classes = datasource?.footerClasses(), classes.count > indexPath.section {
                let clazz = classes[indexPath.section]
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
            } else if let clazz = datasource?.footerClasses()?.first {
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: NSStringFromClass(clazz), for: indexPath) as! DatasourceCell
            } else {
                cell = collectionView.dequeueReusableSupplementaryView(ofKind: kind, withReuseIdentifier: defaultFooterId, for: indexPath) as! DatasourceCell
            }

            cell.datasource = datasource?.footerItem(indexPath.section)
        }

        cell.controller = self

        return cell
    }

    open func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: view.frame.width, height: 50)
    }
}
