package pl.coderslab.charity.settings.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.app.category.Category;
import pl.coderslab.charity.app.category.CategoryRepository;

public class CategoryConverter implements Converter<String,Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert (String s) {
        return this.categoryRepository.findById(Long.parseLong(s)).orElseThrow(()->new IllegalArgumentException("Category not found"));
    }
}
