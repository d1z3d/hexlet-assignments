package exercise.mapper;

import exercise.dto.CategoryCreateDTO;
import exercise.dto.CategoryDTO;
import exercise.model.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-24T00:14:48+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl extends CategoryMapper {

    @Override
    public Category map(CategoryCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setName( dto.getName() );

        return category;
    }

    @Override
    public CategoryDTO map(Category model) {
        if ( model == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( model.getId() );
        categoryDTO.setName( model.getName() );
        categoryDTO.setCreatedAt( model.getCreatedAt() );

        return categoryDTO;
    }
}
