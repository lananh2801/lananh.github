package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.ProductTypeRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.DTO.Response.ProductTypeResponseDTO;
import com.example.clothes.Entity.ProductType;
import com.example.clothes.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductTypeController {

    @Autowired
    ProductTypeService productTypeService;

    @PostMapping("add-product-type")
    public ProductTypeResponseDTO addProductType(@RequestBody ProductTypeRequestDTO productTypeRequestDTO) {
        return productTypeService.addProductType(productTypeRequestDTO);
    }

    @GetMapping("get-product-type")
    public ProductTypeResponseDTO getProductType(@RequestParam Long id) {
        return productTypeService.getProductType(id);
    }
}
