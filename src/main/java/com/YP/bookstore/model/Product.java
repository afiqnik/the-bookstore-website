package com.YP.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String publisher;
    private Date publishedDate;
    private String description;
    private String isbnIdentifier;
    private Integer pageCount;
    private Integer quantity;
    private String printType;
    private String categories;
    private Double averageRating;
    private Integer ratingsCount;
    private String language;
    private String imageLinks;
    private Double listPrice;
    private String listPriceCurrency;
    private Double retailPrice;
    private String retailPriceCurrency;
    private Boolean isBestseller;
    private Boolean isNewArrival;
}
