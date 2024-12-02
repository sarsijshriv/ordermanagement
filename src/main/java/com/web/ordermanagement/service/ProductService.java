package com.web.ordermanagement.service;

import com.web.ordermanagement.model.Product;
import com.web.ordermanagement.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product createProduct(Product productObject) {
        Product product = new Product();
        product.setName(productObject.getName());
        product.setDescription(productObject.getDescription());
        product.setManufacturing_date(productObject.getManufacturing_date());
        product.setPrice(productObject.getPrice());
        product.setExpiry_date(productObject.getExpiry_date());
        product.setQuantity(productObject.getQuantity());
        product.setCreated_at(Instant.now());
        product.setUpdated_at(Instant.now());
        productRepository.save(product);
        return product;
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }

    @Transactional
    public ResponseEntity<?> updateProductById(Long id, Product productObj) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product prodObj = product.get();
            prodObj.setName(productObj.getName());
            prodObj.setDescription(productObj.getDescription());
            prodObj.setPrice(productObj.getPrice());
            prodObj.setQuantity(productObj.getQuantity());
            prodObj.setManufacturing_date(productObj.getManufacturing_date());
            prodObj.setExpiry_date(productObj.getExpiry_date());
            prodObj.setUpdated_at(Instant.now());
            productRepository.save(prodObj);
            return ResponseEntity.ok(prodObj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }

    @Transactional
    public ResponseEntity<?> deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }
}
