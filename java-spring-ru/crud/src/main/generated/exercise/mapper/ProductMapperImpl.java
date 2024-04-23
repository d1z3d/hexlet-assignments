package exercise.mapper;

import exercise.dto.ProductCreateDTO;
import exercise.dto.ProductDTO;
import exercise.dto.ProductUpdateDTO;
import exercise.model.Category;
import exercise.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-24T00:14:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl extends ProductMapper {

    @Autowired
    private JsonNullableMapper jsonNullableMapper;
    @Autowired
    private ReferenceMapper referenceMapper;

    @Override
    public Product map(ProductCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setCategory( referenceMapper.toEntity( dto.getCategoryId(), Category.class ) );
        product.setTitle( dto.getTitle() );
        product.setPrice( dto.getPrice() );

        return product;
    }

    @Override
    public ProductDTO map(Product model) {
        if ( model == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setCategoryId( modelCategoryId( model ) );
        productDTO.setCategoryName( modelCategoryName( model ) );
        productDTO.setId( model.getId() );
        productDTO.setTitle( model.getTitle() );
        productDTO.setPrice( model.getPrice() );
        productDTO.setCreatedAt( model.getCreatedAt() );
        productDTO.setUpdatedAt( model.getUpdatedAt() );

        return productDTO;
    }

    @Override
    public void update(ProductUpdateDTO dto, Product model) {
        if ( dto == null ) {
            return;
        }

        if ( jsonNullableMapper.isPresent( dto.getCategoryId() ) ) {
            model.setCategory( referenceMapper.toEntity( jsonNullableMapper.unwrap( dto.getCategoryId() ), Category.class ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getTitle() ) ) {
            model.setTitle( jsonNullableMapper.unwrap( dto.getTitle() ) );
        }
        if ( jsonNullableMapper.isPresent( dto.getPrice() ) ) {
            model.setPrice( jsonNullableMapper.unwrap( dto.getPrice() ) );
        }
    }

    private Long modelCategoryId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        long id = category.getId();
        return id;
    }

    private String modelCategoryName(Product product) {
        if ( product == null ) {
            return null;
        }
        Category category = product.getCategory();
        if ( category == null ) {
            return null;
        }
        String name = category.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
