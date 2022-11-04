package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.OrderConvert;
import com.example.clothes.Convert.ProductConvert;
import com.example.clothes.Convert.UserConvert;
import com.example.clothes.DTO.Request.OrderRequestDTO;
import com.example.clothes.DTO.Request.ProductRequestDTO;
import com.example.clothes.DTO.Response.OrderResponseDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.Order;
import com.example.clothes.Entity.OrderProduct;
import com.example.clothes.Entity.Product;
import com.example.clothes.Entity.User;
import com.example.clothes.Repository.OrderProductRepository;
import com.example.clothes.Repository.OrderRepository;
import com.example.clothes.Repository.ProductRepository;
import com.example.clothes.Repository.UserRepository;
import com.example.clothes.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    OrderConvert orderConvert;
    @Autowired
    ProductConvert productConvert;
    @Autowired
    UserConvert userConvert;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public OrderResponseDTO addOrder(OrderRequestDTO orderRequestDTO) {
        Order order = orderConvert.toEntity(orderRequestDTO);
        User user = userRepository.getById(orderRequestDTO.getUserNo());
        order.setUser(user);
        order = orderRepository.save(order);
        List<OrderProduct> orderProducts = new ArrayList<>();
        for (ProductRequestDTO productRequestDTO: orderRequestDTO.getProductRequestDTOS()) {
            OrderProduct orderProduct = new OrderProduct();
            Product product = productConvert.toEntity(productRequestDTO);
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProducts.add(orderProduct);
        }
        order.setOrderProducts(orderProducts);
        orderProducts = orderProductRepository.saveAll(orderProducts);
//      Tra ra data
        Order orderGet = orderRepository.findById(order.getOderNo()).get();
        OrderResponseDTO orderResponseDTO = orderConvert.toDTO(orderGet);
        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        orderResponseDTO.setUserResponseDTO(userResponseDTO);

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        BigDecimal amountOfMoney = BigDecimal.ZERO;
        for (OrderProduct orderProductGet : orderGet.getOrderProducts()) {
            Product product = productRepository.getById(orderProductGet.getProduct().getProductNo());
            ProductResponseDTO productResponseDTO = productConvert.toDTO(product);
            productResponseDTOList.add(productResponseDTO);
            amountOfMoney = amountOfMoney.add(product.getPrice());
        }
        orderResponseDTO.setProductResponseDTOList(productResponseDTOList);
        orderResponseDTO.setAmountOfMoney(amountOfMoney);

        return orderResponseDTO;
    }

    @Override
    public OrderResponseDTO getOrder(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            OrderResponseDTO orderDTO = orderConvert.toDTO(order);

            List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

            BigDecimal totalAmount = BigDecimal.ZERO;

            for (OrderProduct orderProduct : order.getOrderProducts()) {
                ProductResponseDTO productResponseDTO = productConvert.toDTO(orderProduct.getProduct());
                productResponseDTOList.add(productResponseDTO);

                totalAmount = totalAmount.add(orderProduct.getProduct().getPrice());
            }
            orderDTO.setAmountOfMoney(totalAmount);
            orderDTO.setProductResponseDTOList(productResponseDTOList);
            return orderDTO;
        }
        return new OrderResponseDTO();
    }

    @Transactional
    @Override
    public void deteleOrderById(Long id) {
            orderProductRepository.deleteOrderProductsByOrderNo(id);
            orderRepository.deleteById(id);
    }
}
