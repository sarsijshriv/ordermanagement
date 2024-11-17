package com.web.ordermanagement.controller;

import com.web.ordermanagement.model.Product;
import com.web.ordermanagement.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    Product createProduct(@RequestBody Product productObject){
        return productService.createProduct(productObject);
    }

    @GetMapping("/")
    List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id){
        return productService.findProductById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> updateProductById(@PathVariable Long id, @RequestBody Product productObj){
        return productService.updateProductById(id, productObj);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

}
