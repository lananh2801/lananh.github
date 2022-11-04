package com.example.clothes.Service;

import com.example.clothes.DTO.Request.ProductTypeRequestDTO;
import com.example.clothes.DTO.Response.ProductTypeResponseDTO;
import com.example.clothes.Entity.ProductType;

public interface ProductTypeService {
    ProductTypeResponseDTO addProductType(ProductTypeRequestDTO productTypeRequestDTO);
    ProductTypeResponseDTO getProductType(Long id);
    void deleteProductType(Long id);

    ProductTypeResponseDTO updateProductType(ProductTypeRequestDTO productTypeRequestDTO);
}
