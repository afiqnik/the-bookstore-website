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
    private String title;
    private String author;
    private String publisher;
    private Date publishedDate;
    private String description;
    private String isbnIdentifier;
    private Integer pageCount;
    private String categories;
    private String language;
    private String imageLinks;
    private Double listPrice;
    private Double retailPrice;
    private Boolean isBestseller;
    private Boolean isNewArrival;
}
