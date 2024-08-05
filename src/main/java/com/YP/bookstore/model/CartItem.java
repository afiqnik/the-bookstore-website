package com.YP.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userID",unique = false,nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "productID",nullable = false,unique = false)
    private Product product;

    @ManyToOne(optional = true)
    @JoinColumn(name = "orderID", unique = false)
    private Orders order;

    private Integer quantity;

    private Double price;


}
