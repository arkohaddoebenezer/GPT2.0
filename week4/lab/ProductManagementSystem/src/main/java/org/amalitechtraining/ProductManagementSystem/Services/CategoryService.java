package org.amalitechtraining.ProductManagementSystem.Services;

import org.amalitechtraining.ProductManagementSystem.Models.Category;
import org.amalitechtraining.ProductManagementSystem.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllRootCategories() {
        List<Category> categories = categoryRepository.findByParentIsNull();
        return new ArrayList<>(categories);
    }

    public Category createCategory(String name, Long parentId) {
        Category parent = null;
        if (parentId != null) {
            parent = categoryRepository.findById(parentId)
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
        }
        Category category = new Category(name, parent);
        return categoryRepository.save(category);
    }
}