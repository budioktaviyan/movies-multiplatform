import UIKit

open class DatasourceCell: UICollectionViewCell {

    open var datasource: Any?

    open weak var controller: DatasourceController?

    public override init(frame: CGRect) {
        super.init(frame: frame)
        setupViews()
    }

    public required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    open func setupViews() {
        clipsToBounds = true
    }
}
