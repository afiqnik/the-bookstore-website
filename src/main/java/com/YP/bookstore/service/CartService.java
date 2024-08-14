package com.YP.bookstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.YP.bookstore.model.CartItem;
import com.YP.bookstore.repository.CartRepository;
import com.YP.bookstore.model.Product;
import com.YP.bookstore.model.User;
import com.YP.bookstore.repository.ProductRepository;
import com.YP.bookstore.repository.UserRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository; // Repository for CartItem operations

    @Autowired
    private ProductRepository productRepository; // Repository for Product operations

    @Autowired
    private UserRepository userRepository; // Repository for User operations

    private static final Logger logger = LoggerFactory.getLogger(CartService.class); // Logger for logging purposes

    /**
     * Updates the quantity of a cart item based on the action (increase or
     * decrease).
     * If the quantity becomes zero or less, the item is removed from the cart.
     * 
     * @param id     the id of the cart item
     * @param action the action to perform (increase or decrease)
     */
    public void updateQuantity(Long id, String action) {
        CartItem cart = cartRepository.findById(id).orElse(null); // Find the cart item by id
        Product product = productRepository.findById(cart.getProduct().getId()).orElse(null); // Find the product
                                                                                              // associated with the
                                                                                              // cart item
        int updateQ;

        if (action.equalsIgnoreCase("decrease")) { // If the action is to decrease the quantity
            updateQ = cart.getQuantity() - 1;

            if (updateQ <= 0) { // If the updated quantity is zero or less, delete the cart item
                cartRepository.delete(cart);
            } else { // Otherwise, update the quantity and price, and save the cart item
                cart.setQuantity(updateQ);
                cart.setPrice(product.getListPrice() * updateQ);
                cartRepository.save(cart);
            }
        } else { // If the action is to increase the quantity
            updateQ = cart.getQuantity() + 1;
            cart.setQuantity(updateQ);
            cart.setPrice(product.getListPrice() * updateQ);
            cartRepository.save(cart);
        }
    }

    /**
     * Retrieves all cart items.
     * 
     * @return a list of all cart items
     */
    public List<CartItem> getAllCarts() {
        return cartRepository.findAll();
    }

    /**
     * Retrieves cart items for a specific user.
     * 
     * @param id the id of the user
     * @return a list of cart items for the user
     */
    public List<CartItem> getCartbyUser(Long id) {
        return cartRepository.findByUserId(id);
    }

    /**
     * Adds a product to the cart for a specific user and order.
     * If the product is already in the cart, the quantity is increased.
     * 
     * @param productID the id of the product to add
     * @param userID    the id of the user
     * @param orderID   the id of the order
     * @return the updated cart item
     */
    public CartItem addtoCart(Long productID, Long userID, Long orderID) {
        Product product = productRepository.findById(productID).get(); // Find the product by id
        User user = userRepository.findById(userID).get(); // Find the user by id
        CartItem cartstatus = cartRepository.findByProductIdAndUserIdAndOrderId(productID, userID, orderID); // Find the
                                                                                                             // cart
                                                                                                             // item if
                                                                                                             // it
                                                                                                             // already
                                                                                                             // exists
        logger.info("Cart items received : " + cartstatus);
        CartItem cart = null;

        if (ObjectUtils.isEmpty(cartstatus)) { // If the cart item does not exist, create a new one
            logger.info("Creating cart for user");
            cart = new CartItem();
            cart.setUser(user);
            cart.setProduct(product);
            cart.setPrice(product.getListPrice());
            cart.setQuantity(1);
            logger.info("Adding cart to user with product id not added before");
        } else { // If the cart item exists, update the quantity and price
            logger.info("Adding quantity for cart item already added to cart");
            cart = cartstatus;
            cart.setQuantity(cart.getQuantity() + 1);
            cart.setPrice(cart.getPrice() + product.getListPrice());
        }
        CartItem saveCart = cartRepository.save(cart); // Save the cart item
        return saveCart;
    }

    /**
     * Deletes a cart item by id.
     * 
     * @param id the id of the cart item to delete
     */
    public void deleteCart(Long id) {
        CartItem cart = cartRepository.findById(id).orElse(null); // Find the cart item by id
        cartRepository.delete(cart); // Delete the cart item
    }
}
