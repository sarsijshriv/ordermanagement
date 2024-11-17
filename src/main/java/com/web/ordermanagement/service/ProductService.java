package com.web.ordermanagement.service;

import com.web.ordermanagement.model.Product;
import com.web.ordermanagement.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product productObject) {
        Product product = new Product();
        product.setName(productObject.getName());
        product.setDescription(productObject.getDescription());
        product.setManufacturing_date(productObject.getManufacturing_date());
        product.setPrice(productObject.getPrice());
        product.setExpiry_date(productObject.getExpiry_date());
        productRepository.save(product);
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<?> findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }

    public ResponseEntity<?> updateProductById(Long id, Product productObj) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            Product prodObj = product.get();
            prodObj.setName(productObj.getName());
            prodObj.setDescription(productObj.getDescription());
            prodObj.setPrice(productObj.getPrice());
            prodObj.setManufacturing_date(productObj.getManufacturing_date());
            prodObj.setExpiry_date(productObj.getExpiry_date());
            productRepository.save(prodObj);
            return ResponseEntity.ok(prodObj);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }

    public ResponseEntity<?> deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exists.");
    }
}