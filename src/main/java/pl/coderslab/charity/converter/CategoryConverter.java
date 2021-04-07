package pl.coderslab.charity.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

public class CategoryConverter implements Converter<String,Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert (String s) {
        return this.categoryRepository.findById(Long.parseLong(s)).orElseThrow(()->new IllegalArgumentException("Category not found"));
    }
}
