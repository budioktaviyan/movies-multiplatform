import UIKit

class DefaultHeader: DefaultCell {

    override var datasource: Any? {
        didSet {
            let text = datasource as? String ?? "Default Header"
            label.text = text
        }
    }

    override func setupViews() {
        label.textAlignment = .center
    }
}

class DefaultFooter: DefaultCell {

    override var datasource: Any? {
        didSet {
            let text = datasource as? String ?? "Default Footer"
            label.text = text
        }
    }

    override func setupViews() {
        label.textAlignment = .center
    }
}

class DefaultCell: DatasourceCell {

    fileprivate lazy var label: UILabel = UILabel()

    override var datasource: Any? {
        didSet {
            let text = datasource as? String ?? datasource.debugDescription
            label.text = text
        }
    }

    override func setupViews() {
        addSubview(label)
        label.anchor(
            safeAreaLayoutGuide.topAnchor,
            left: leftAnchor,
            bottom: bottomAnchor,
            right: rightAnchor,
            topConstant: 0,
            leftConstant: 8,
            bottomConstant: 0,
            rightConstant: 8,
            widthConstant: 0,
            heightConstant: 0
        )
    }
}
