package com.YP.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.YP.bookstore.model.Product;

import java.util.List;

/**
 * ProductRepository interface for CRUD operations on Product entities.
 * Extends JpaRepository to provide standard JPA data access methods.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository<Product, Long> indicates that this repository manages Product
    // entities with a primary key of type Long.

    /**
     * Finds all products that are marked as bestsellers.
     * 
     * @return a list of bestseller products.
     */
    List<Product> findByIsBestsellerTrue();

    /**
     * Finds all products that are marked as new arrivals.
     * 
     * @return a list of new arrival products.
     */
    List<Product> findByIsNewArrivalTrue();

    /**
     * Finds all products whose title or author contains the specified string
     * (case-insensitive).
     * 
     * @param title  the title string to search for.
     * @param author the author string to search for.
     * @return a list of products with matching title or author.
     */
    List<Product> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String Author);
}
