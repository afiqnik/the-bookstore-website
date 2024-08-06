package com.YP.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.YP.bookstore.model.CartItem;

public interface CartRepository extends JpaRepository<CartItem ,Long> {
    
    public CartItem findById(Integer id); 

    public CartItem findByProductIdAndUserIdAndOrderId(Long productID,Long userID,Long orderID);

    public List<CartItem> findByUserId(Long userID);
}
