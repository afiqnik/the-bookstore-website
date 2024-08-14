package com.YP.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.YP.bookstore.model.Orders;

/**
 * OrdersRepository interface extends JpaRepository to provide CRUD operations
 * for Orders entity.
 * This interface enables Spring Data JPA to generate the necessary SQL queries
 * for interacting with the database.
 */
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    /**
     * Custom query method to find a list of Orders by the userId.
     * Spring Data JPA will automatically implement this method based on its name.
     *
     * @param id the ID of the user whose orders are to be retrieved
     * @return a list of Orders associated with the given userId
     */
    List<Orders> findByUserId(Long id);

}
