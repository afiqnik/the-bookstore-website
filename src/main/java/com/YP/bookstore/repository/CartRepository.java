package com.YP.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.YP.bookstore.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem ,Long> {
    
    public CartItem findById(Integer id); 

    public CartItem findByProductIdAndUserId(Long productID,Long userID);
}
