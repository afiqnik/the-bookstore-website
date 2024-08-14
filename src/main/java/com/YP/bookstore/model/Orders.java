package com.YP.bookstore.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Orders {

    // Primary key for the Orders entity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // One-to-Many relationship with CartItem, mapped by the "order" field in
    // CartItem
    @OneToMany(mappedBy = "order")
    private List<CartItem> cart;

    // Many-to-One relationship with User, join column named "userID", non-nullable
    @ManyToOne
    @JoinColumn(name = "userID", unique = false, nullable = false)
    private User user;

    // Total price of the order
    private Double totalprice;

    // Date when the order was placed
    private LocalDate orderdate;
}
