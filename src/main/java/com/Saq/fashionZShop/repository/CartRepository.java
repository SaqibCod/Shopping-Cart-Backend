package com.Saq.fashionZShop.repository;

import com.Saq.fashionZShop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
