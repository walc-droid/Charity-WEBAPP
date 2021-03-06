package pl.coderslab.charity.app.category;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    public void delete(Long id) {
        this.categoryRepository.deleteById(id);
    }

    public Category getById(Long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }


    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

}
