package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.ProductRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.Entity.Product;
import com.example.clothes.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("add-product")
    public ProductResponseDTO addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        return productService.addProduct(productRequestDTO);
    }

    @GetMapping("get-product")
    public ProductResponseDTO getProduct(@RequestParam Long id) {
        return productService.getProduct(id);
    }
}
