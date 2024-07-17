package org.amalitechtraining.ProductManagementSystem.Controllers;

import org.amalitechtraining.ProductManagementSystem.Models.Product;
import org.amalitechtraining.ProductManagementSystem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/products")
    public class ProductController {

        @Autowired
        private ProductRepository productRepository;

        @GetMapping
        public ResponseEntity<List<Product>> getAllProducts() {
            List<Product> products = (List<Product>) productRepository.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Product> addProduct(@RequestParam("name") String name,
                                                  @RequestParam("description") String description,
                                                  @RequestParam("category") String category,
                                                  @RequestParam("image") String image,
                                                  @RequestParam("price") Double price) {
            Product product = new Product(name, description, category, price, image);
            productRepository.save(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Product> getProductById(@PathVariable("id") Long productId) {
            Optional<Product> product = productRepository.findById(productId);
            return product.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PutMapping("/{id}")
        public ResponseEntity<Product> editProduct(@PathVariable("id") Long productId,
                                                   @RequestParam("name") String newName,
                                                   @RequestParam("price") String newPrice,
                                                   @RequestParam("category") String newCategory,
                                                   @RequestParam("description") String newDescription) {
            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (optionalProduct.isPresent()) {
                Product product = optionalProduct.get();
                product.setName(newName);
                product.setDescription(newDescription);
                productRepository.save(product);
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId) {
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        @GetMapping("/category/{category}")
        public ResponseEntity<List<Product>> filterByCategory(@PathVariable("category") String category) {
            List<Product> products = productRepository.findByCategory(category);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }

        @GetMapping("/search")
        public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query) {
            List<Product> products = productRepository.findByNameContainingOrDescriptionContaining(query, query);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }