package com.example.clothes.Convert;

import com.example.clothes.DTO.Request.OrderRequestDTO;
import com.example.clothes.DTO.Response.OrderResponseDTO;
import com.example.clothes.Entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderConvert {
    public OrderResponseDTO toDTO(Order order) {
        OrderResponseDTO orderDTO = new OrderResponseDTO();
        orderDTO.setOrderNo(order.getOderNo());
        return orderDTO;
    }

    public Order toEntity(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        order.setOderNo(orderRequestDTO.getOrderNo());
        return order;
    }
}
