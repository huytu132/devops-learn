package org.example.devopslearn.controller;

import org.apache.coyote.Response;
import org.example.devopslearn.dto.request.ProductRequest;
import org.example.devopslearn.model.Product;
import org.example.devopslearn.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
