package com.YP.bookstore.service;

import com.YP.bookstore.model.Product;
import com.YP.bookstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Method to get a product by its ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Method to get a product by its bestseller status
    public List<Product> getBestsellerProducts() {
        return productRepository.findByIsBestsellerTrue();
    }

}
