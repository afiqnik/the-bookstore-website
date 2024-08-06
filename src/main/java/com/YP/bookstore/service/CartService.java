package com.YP.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.YP.bookstore.controller.ProductController;
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

    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    public void updateQuantity(Long id, String action){

        CartItem cart = cartRepository.findById(id).orElse(null);
        Product product = productRepository.findById(cart.getProduct().getId()).orElse(null);
        int updateQ;

        if(action.equalsIgnoreCase("decrease")){
            updateQ=cart.getQuantity()-1;

            if(updateQ <=0){
                cartRepository.delete(cart);
            }
            else{
                cart.setQuantity(updateQ);
                cart.setPrice(product.getListPrice()*updateQ);
                cartRepository.save(cart);
            }
        }
        else{
            updateQ=cart.getQuantity()+1;
            cart.setQuantity(updateQ);
            cart.setPrice(product.getListPrice()*updateQ);
            cartRepository.save(cart);
        }
    }

    public List<CartItem> getAllCarts() {
        return cartRepository.findAll();
        
    }

    public List<CartItem> getCartbyUser(Long id){
        return cartRepository.findByUserId(id);
    }

    public CartItem addtoCart(Long productID,Long userID,Long orderID) {
        Product product = productRepository.findById(productID).get();
        User user = userRepository.findById(userID).get();
        CartItem cartstatus = cartRepository.findByProductIdAndUserIdAndOrderId(productID,userID,orderID);
        logger.info("Cart items received : "+cartstatus);
        CartItem cart=null;
        
        if(ObjectUtils.isEmpty(cartstatus)){
            logger.info("Creating cart for user");
            cart=new CartItem();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setPrice(product.getListPrice());
            cart.setQuantity(1);
        }
        else{
            logger.info("Adding quantity for cart item already added to cart");
            cart=cartstatus;
            cart.setQuantity(cart.getQuantity()+1);
            cart.setPrice(cart.getPrice()+product.getListPrice());
            }
        CartItem saveCart = cartRepository.save(cart);
        return saveCart;

    }
    public void deleteCart(Long id) {
        CartItem cart = cartRepository.findById(id).orElse(null);
        cartRepository.delete(cart);
    }
}
