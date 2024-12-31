package com.Saq.fashionZShop.service.cart;

import com.Saq.fashionZShop.model.Cart;
import com.Saq.fashionZShop.model.User;

import java.math.BigDecimal;

public interface ICartService {

    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
