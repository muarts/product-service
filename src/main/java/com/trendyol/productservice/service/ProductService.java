package com.trendyol.productservice.service;

import com.trendyol.productservice.entity.Product;
import com.trendyol.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    public Product saveProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    public Product updateProduct(Long id, Product product) {
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
