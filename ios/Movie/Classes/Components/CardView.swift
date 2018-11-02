import UIKit

open class CardView: UIView {

    public init() {
        super.init(frame: .zero)
        clipsToBounds = false
        layer.shadowColor = UIColor.black.cgColor
        layer.shadowOffset = CGSize(width: 0, height: 1)
        layer.shadowOpacity = 0.5
        layer.shadowRadius = 1
    }

    required public init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}
