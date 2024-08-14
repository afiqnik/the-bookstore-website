package com.YP.bookstore.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.model.Orders;
import com.YP.bookstore.model.User;
import com.YP.bookstore.repository.OrdersRepository;

@Service
public class OrderService {

    // Autowiring the OrdersRepository to interact with the database
    @Autowired
    private OrdersRepository ordersRepository;

    /**
     * Creates an order for the user based on the cart items.
     *
     * @param cart List of CartItem objects representing the items in the cart.
     * @param user User object representing the user placing the order.
     * @return Orders object representing the created order.
     */
    public Orders createOrder(List<CartItem> cart, User user) {
        Double total = 0.0; // Initialize total price
        Orders order = new Orders(); // Create a new Orders object
        order.setCart(cart); // Set the cart items for the order
        order.setUser(user); // Set the user for the order
        order.setOrderdate(LocalDate.now()); // Set the order date to the current date

        // Calculate the total price and associate cart items with the order
        for (CartItem carts : cart) {
            carts.setOrder(order); // Set the order for each cart item
            total += carts.getPrice(); // Add the price of each item to the total
        }

        order.setTotalprice(total); // Set the total price for the order
        ordersRepository.save(order); // Save the order to the database

        return order; // Return the created order
    }

    /**
     * Retrieves a list of orders for a specific user.
     *
     * @param user User object representing the user whose orders are to be
     *             retrieved.
     * @return List of Orders objects representing the user's orders.
     */
    public List<Orders> viewOrders(User user) {
        return ordersRepository.findByUserId(user.getId()); // Fetch orders by user ID
    }
}
