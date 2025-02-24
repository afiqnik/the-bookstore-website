package com.YP.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * The Product class represents a product entity in the bookstore application.
 * It is annotated with @Entity to indicate that it is a JPA entity.
 * The @Data annotation from Lombok generates getters, setters, and other
 * utility methods.
 */
@Entity
@Data
public class Product {

    /**
     * The unique identifier for each product.
     * It is annotated with @Id to denote the primary key.
     * The @GeneratedValue annotation specifies that the ID should be generated
     * automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The title of the book.
    private String title;

    // The author of the book.
    private String author;

    // The publisher of the book.
    private String publisher;

    // The date when the book was published.
    private Date publishedDate;

    // A brief description of the book.
    @Column(columnDefinition = "TEXT")
    private String description;

    // The ISBN identifier of the book.
    private String isbnIdentifier;

    // The number of pages in the book.
    private Integer pageCount;

    // The categories or genres the book belongs to.
    private String categories;

    // The language in which the book is written.
    private String language;

    // A URL or path to the image of the book's cover.
    private String imageLinks;

    // The list price of the book.
    private Double listPrice;

    // The retail price of the book.
    private Double retailPrice;

    // A flag indicating whether the book is a bestseller.
    private Boolean isBestseller;

    // A flag indicating whether the book is a new arrival.
    private Boolean isNewArrival;
}
