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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;
    private Date publishedDate;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String isbnIdentifier;
    private Integer pageCount;
    private String categories;
    private String language;
    private String imageLinks;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "retail_price")
    private Double retailPrice;

    @Column(name = "is_bestseller")
    private Boolean isBestseller;

    @Column(name = "is_new_arrival")
    private Boolean isNewArrival;
}
