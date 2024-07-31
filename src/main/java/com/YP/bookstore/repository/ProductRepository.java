package com.YP.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.YP.bookstore.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> { // JpaRepository<entity, data type of primary key of entity>
    List<Product> findByIsBestsellerTrue();
    List<Product> findByIsNewArrivalTrue();
}
