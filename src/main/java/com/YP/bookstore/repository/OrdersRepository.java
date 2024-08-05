package com.YP.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.YP.bookstore.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Long>{

    List<Orders> findByUserId(Long id);
    
}
