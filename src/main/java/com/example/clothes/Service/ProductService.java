package com.example.clothes.Service;

import com.example.clothes.DTO.Request.ProductRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.Entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO getProduct(Long id);

    void deleteProduct(Long id);

}
