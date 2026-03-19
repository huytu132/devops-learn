package org.example.devopslearn.service;

import org.example.devopslearn.dto.request.ProductRequest;
import org.example.devopslearn.model.Product;
import org.example.devopslearn.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id){
        return productRepository.findById(id)
                .orElseThrow();
    }

    public Product createProduct(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        return productRepository.save(product);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Successfully deleted!";
    }

    public Product updateProduct(Long id, ProductRequest request){
        Product oldProduct = productRepository.findById(id)
                .orElseThrow();

        oldProduct.setName(request.getName());
        return productRepository.save(oldProduct);
    }
}
