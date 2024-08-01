package com.YP.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.repository.CartRepository;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.model.User;
import com.YP.bookstore.repository.ProductRepository;
import com.YP.bookstore.repository.UserRepository;

@Service
public class CartService {
    

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    public CartItem getCartbyUser(Integer id){
        CartItem cart = cartRepository.findById(id);
        return cart;
    }

    public List<CartItem> getAllCarts() {
        return cartRepository.findAll();
        
    }

    public CartItem addtoCart(Long productID,Long userID) {
        Product product = productRepository.findById(productID).get();
        User user = userRepository.findById(userID).get();
        CartItem cartstatus = cartRepository.findByProductIdAndUserId(productID,userID);

        CartItem cart=null;

        if(ObjectUtils.isEmpty(cartstatus)){
            cart=new CartItem();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setPrice(product.getListPrice());
            cart.setQuantity(1);
        }else{
            cart=cartstatus;
            cart.setQuantity(cart.getQuantity()+1);
            cart.setPrice(cart.getPrice()+product.getListPrice());
        }
        CartItem saveCart = cartRepository.save(cart);

        return saveCart;

    }
}