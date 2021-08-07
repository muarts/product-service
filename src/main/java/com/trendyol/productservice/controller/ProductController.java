package com.trendyol.productservice.controller;

import com.trendyol.productservice.entity.Product;
import com.trendyol.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Product> post(@RequestBody Product product) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productService.saveProduct(product).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/products/{id}")
    public ResponseEntity<Product> put(@PathVariable Long id, @RequestBody Product product) {
        return null;
    }

    @DeleteMapping(path = "/products/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
