package exercise.specification;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withTitleCont(params.getTitleCont())
                .and(withCategoryId(params.getCategoryId())
                .and(withPriceLT(params.getPriceLt()))
                .and(withPriceGT(params.getPriceGt()))
                .and(withRatingGT(params.getRatingGt())));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return (root, query, criteriaBuilder) -> titleCont == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("title"), titleCont);
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> categoryId == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> withPriceLT(Integer priceLT) {
        return (root, query, criteriaBuilder) -> priceLT == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.lessThan(root.get("price"), priceLT);
    }

    private Specification<Product> withPriceGT(Integer priceGT) {
        return (root, query, criteriaBuilder) -> priceGT == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("price"), priceGT);
    }

    private Specification<Product> withRatingGT(Double ratingGT) {
        return (root, query, criteriaBuilder) -> ratingGT == null
                ? criteriaBuilder.conjunction()
                : criteriaBuilder.greaterThan(root.get("rating"), ratingGT);
    }
}
// END
