package com.smallschool.service;


@Service
public class CartService {
    public String getCartInfo(String userId) {

        return "Cart information for user " + userId;
    }

    public void addToCart(String userId, String productId) {

        System.out.println("Product " + productId + " added to cart for user " + userId);
    }

    public void removeFromCart(String userId, String productId) {

        System.out.println("Product " + productId + " removed from cart for user " + userId);
    }

    public void processCheckout(String userId, String orderInfo) {

        System.out.println("Checkout and payment processed for user " + userId + ": " + orderInfo);
    }
}
