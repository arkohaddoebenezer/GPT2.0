package org.amalitechtraining.ProductManagementSystem.Controllers;

import org.amalitechtraining.ProductManagementSystem.Models.Category;
import org.amalitechtraining.ProductManagementSystem.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllRootCategories() {
        return categoryService.getAllRootCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request.getName(), request.getParentId());
    }

    public static class CategoryRequest {
        private String name;
        private Long parentId;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getParentId() {
            return parentId;
        }

        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }
    }
}
