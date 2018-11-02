import UIKit

extension UIView {

    func anchor(
        _ top: NSLayoutYAxisAnchor? = nil,
        left: NSLayoutXAxisAnchor? = nil,
        bottom: NSLayoutYAxisAnchor? = nil,
        right: NSLayoutXAxisAnchor? = nil,
        topConstant: CGFloat = 0,
        leftConstant: CGFloat = 0,
        bottomConstant: CGFloat = 0,
        rightConstant: CGFloat = 0,
        widthConstant: CGFloat = 0,
        heightConstant: CGFloat = 0) {
        _ = anchorWithReturnAnchors(
            top, left: left,
            bottom: bottom,
            right: right,
            topConstant: topConstant,
            leftConstant: leftConstant,
            bottomConstant: bottomConstant,
            rightConstant: rightConstant,
            widthConstant: widthConstant,
            heightConstant: heightConstant
        )
    }

    func anchorCenterSuperview() {
        anchorCenterXToSuperview()
        anchorCenterYToSuperview()
    }

    private func anchorWithReturnAnchors(
        _ top: NSLayoutYAxisAnchor? = nil,
        left: NSLayoutXAxisAnchor? = nil,
        bottom: NSLayoutYAxisAnchor? = nil,
        right: NSLayoutXAxisAnchor? = nil,
        topConstant: CGFloat = 0,
        leftConstant: CGFloat = 0,
        bottomConstant: CGFloat = 0,
        rightConstant: CGFloat = 0,
        widthConstant: CGFloat = 0,
        heightConstant: CGFloat = 0) -> [NSLayoutConstraint] {
        translatesAutoresizingMaskIntoConstraints = false

        var anchors = [NSLayoutConstraint]()
        if let top = top { anchors.append(topAnchor.constraint(equalTo: top, constant: topConstant)) }
        if let left = left { anchors.append(leftAnchor.constraint(equalTo: left, constant: leftConstant)) }
        if let bottom = bottom { anchors.append(bottomAnchor.constraint(equalTo: bottom, constant: -bottomConstant)) }
        if let right = right { anchors.append(rightAnchor.constraint(equalTo: right, constant: -rightConstant)) }
        if widthConstant > 0 { anchors.append(widthAnchor.constraint(equalToConstant: widthConstant)) }
        if heightConstant > 0 { anchors.append(heightAnchor.constraint(equalToConstant: heightConstant)) }
        anchors.forEach({$0.isActive = true})

        return anchors
    }

    private func anchorCenterXToSuperview(constant: CGFloat = 0) {
        translatesAutoresizingMaskIntoConstraints = false
        guard let anchor = superview?.centerXAnchor else { return }
        centerXAnchor.constraint(equalTo: anchor, constant: constant).isActive = true
    }

    private func anchorCenterYToSuperview(constant: CGFloat = 0) {
        translatesAutoresizingMaskIntoConstraints = false
        guard let anchor = superview?.centerYAnchor else { return }
        centerYAnchor.constraint(equalTo: anchor, constant: constant).isActive = true
    }
}
