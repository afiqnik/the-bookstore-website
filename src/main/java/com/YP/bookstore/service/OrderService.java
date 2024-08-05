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
    
    @Autowired
    private OrdersRepository ordersRepository;

    public Orders createOrder(List<CartItem> cart, User user){
        Double total = 0.0;
        Orders order = new Orders();
        order.setCart(cart);
        order.setUser(user);
        order.setOrderdate(LocalDate.now());
        for(CartItem carts:cart){
            carts.setOrder(order);
            total+=carts.getPrice();
        }
        order.setTotalprice(total);

        ordersRepository.save(order);

        return order;
    }

    public List<Orders> viewOrders(User user){
        return ordersRepository.findByUserId(user.getId());
    }
}
