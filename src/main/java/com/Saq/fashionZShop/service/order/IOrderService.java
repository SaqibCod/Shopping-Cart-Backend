package com.Saq.fashionZShop.service.order;

import com.Saq.fashionZShop.dto.OrderDto;
import com.Saq.fashionZShop.model.Order;

import java.util.List;

public interface IOrderService {

    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}
