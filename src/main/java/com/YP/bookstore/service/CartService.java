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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CartService {
    private static final Logger logger = LoggerFactory.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    // public CartItem getCartbyUser(Integer id){
    //     CartItem cart = cartRepository.findById(id);
    //     return cart;
    // }

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
            logger.info("Adding cart to user with product id not added before");
        }
        else{
            if(cartstatus.getOrder()!=null&&cartstatus.getQuantity()==0){
                cart=new CartItem();
                cart.setUser(user);
                cart.setProduct(product);
                cart.setPrice(product.getListPrice());
                cart.setQuantity(1);
                logger.info("Adding cart to user with product id already added before");
            }
            else if(cartstatus.getOrder()!=null&&cartstatus.getQuantity()>=1){
                cart=cartstatus;
                cart.setQuantity(cart.getQuantity()+1);
                cart.setPrice(cart.getPrice()+product.getListPrice());
                logger.info("Adding quantity of cart to user with product id already added before");

            }
            else{
                cart=cartstatus;
                cart.setQuantity(cart.getQuantity()+1);
                cart.setPrice(cart.getPrice()+product.getListPrice());
                logger.info("Adding quantity of cart to user with product id not added before");
            }
            
            }
        CartItem saveCart = cartRepository.save(cart);

        return saveCart;

    }

    public void deleteCart(Long id) {
        CartItem cart = cartRepository.findById(id).orElse(null);
        cartRepository.delete(cart);
    }
}
