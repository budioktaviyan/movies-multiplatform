import UIKit
import Kingfisher
import KotlinCommon

class HomeCell: DatasourceCell {

    private lazy var card: CardView = {
        let view = CardView()
        view.layer.cornerRadius = 4

        return view
    }()

    private lazy var poster: UIImageView = {
        let view = UIImageView()
        view.contentMode = .scaleAspectFill
        view.clipsToBounds = true

        return view
    }()

    private lazy var title: UILabel = {
        let view = UILabel()
        view.font = UIFont.systemFont(ofSize: 16)
        view.textColor = .black
        view.textAlignment = .left

        return view
    }()

    override var datasource: Any? {
        didSet {
            guard let result = datasource as? Result else { return }
            load(url: result.posterPath)
            title.text = result.title
        }
    }

    override func setupViews() {
        card.backgroundColor = .white
        addSubview(card)
        card.anchor(
            safeAreaLayoutGuide.topAnchor,
            left: leftAnchor,
            bottom: bottomAnchor,
            right: rightAnchor,
            topConstant: 8,
            leftConstant: 1,
            bottomConstant: 8,
            rightConstant: 1,
            widthConstant: 0,
            heightConstant: 0
        )

        card.addSubview(poster)
        poster.anchor(
            card.topAnchor,
            left: card.leftAnchor,
            bottom: nil,
            right: card.rightAnchor,
            topConstant: 0,
            leftConstant: 0,
            bottomConstant: 0,
            rightConstant: 0,
            widthConstant: 0,
            heightConstant: 0
        )

        card.addSubview(title)
        title.anchor(
            poster.bottomAnchor,
            left: card.leftAnchor,
            bottom: nil,
            right: card.rightAnchor,
            topConstant: 8,
            leftConstant: 8,
            bottomConstant: 0,
            rightConstant: 8,
            widthConstant: 0,
            heightConstant: 0
        )
    }

    private func load(url: String) {
        let imageUrl = URL(string: url)
        poster.kf.setImage(
            with: imageUrl,
            placeholder: nil,
            options: nil,
            progressBlock: nil,
            completionHandler: { image, error, cacheType, imageUrl in
                guard let poster = image else { return }
                self.poster.image = UIImage.resize(image: poster, targetSize: CGSize(width: self.contentView.frame.width, height: 128))
        })
    }
}
