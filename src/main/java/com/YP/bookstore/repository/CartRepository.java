package com.YP.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.YP.bookstore.model.CartItem;

/**
 * CartRepository interface for managing CartItem entities.
 * This repository provides CRUD operations and custom query methods for
 * CartItem.
 */
public interface CartRepository extends JpaRepository<CartItem, Long> {

    /**
     * Finds a CartItem by its ID.
     *
     * @param id the ID of the CartItem.
     * @return the CartItem with the given ID, or null if none found.
     */
    public CartItem findById(Integer id);

    /**
     * Finds a CartItem by its product ID, user ID, and order ID.
     *
     * @param productID the ID of the product.
     * @param userID    the ID of the user.
     * @param orderID   the ID of the order.
     * @return the CartItem matching the given product ID, user ID, and order ID, or
     *         null if none found.
     */
    public CartItem findByProductIdAndUserIdAndOrderId(Long productID, Long userID, Long orderID);

    /**
     * Finds all CartItems for a specific user.
     *
     * @param userID the ID of the user.
     * @return a list of CartItems for the given user ID.
     */
    public List<CartItem> findByUserId(Long userID);
}
