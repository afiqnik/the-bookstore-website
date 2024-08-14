package com.YP.bookstore.service;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.repository.CartRepository;
import com.YP.bookstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductService handles all business logic related to products.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    /**
     * Retrieves all products from the repository.
     *
     * @return a list of all products.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product.
     * @return the product with the given ID, or null if not found.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     * Retrieves a list of products that are marked as bestsellers.
     *
     * @return a list of bestseller products.
     */
    public List<Product> getBestsellerProducts() {
        return productRepository.findByIsBestsellerTrue();
    }

    /**
     * Retrieves a list of products that are marked as new arrivals.
     *
     * @return a list of new arrival products.
     */
    public List<Product> getNewArrivalsProducts() {
        return productRepository.findByIsNewArrivalTrue();
    }

    /**
     * Searches for books by title or author.
     * 
     * @param title  the title of the book.
     * @param author the author of the book.
     * @return a list of books that match the search criteria.
     */
    public List<Product> searchBooks(String title, String author) {
        return productRepository.findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(title, author);
    }
}
