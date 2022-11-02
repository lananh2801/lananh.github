package com.example.clothes.Service;

import com.example.clothes.DTO.Request.OrderRequestDTO;
import com.example.clothes.DTO.Response.OrderResponseDTO;
import com.example.clothes.Entity.Order;

public interface OrderService {

    OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO);

    OrderResponseDTO getOrder(Long id);

    void deteleOrderById(Long id);
}
