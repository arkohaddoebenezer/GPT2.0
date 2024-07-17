package org.amalitechtraining.ProductManagementSystem.Repository;

import org.amalitechtraining.ProductManagementSystem.Models.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByParentIsNull();
}