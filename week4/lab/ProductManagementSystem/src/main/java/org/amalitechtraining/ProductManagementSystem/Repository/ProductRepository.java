package org.amalitechtraining.ProductManagementSystem.Repository;

import org.amalitechtraining.ProductManagementSystem.Models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

 public interface ProductRepository extends CrudRepository<Product,Long> {

     List<Product> findByName(String name);

     Product findById(long id);

     List<Product> findByCategory(String category);

     List<Product> findByNameContainingOrDescriptionContaining(String name, String description);

 }
