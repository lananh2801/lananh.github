package com.example.clothes.Convert;


import com.example.clothes.DTO.Request.ProductTypeRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.DTO.Response.ProductTypeResponseDTO;
import com.example.clothes.Entity.Product;
import com.example.clothes.Entity.ProductType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductTypeConvert {
    public ProductTypeResponseDTO toDTO(ProductType productType) {
        ProductTypeResponseDTO productTypeResponseDTO = new ProductTypeResponseDTO();
        productTypeResponseDTO.setProductTypeNo(productType.getProductTypeNo());
        productTypeResponseDTO.setProductTypeName(productType.getProductTypeName());
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        for(Product product : productType.getProducts()) {
            ProductResponseDTO productResponseDTO = new ProductResponseDTO();
            productResponseDTO.setProductNo(product.getProductNo());
            productResponseDTO.setProductName(product.getProductName());
            productResponseDTO.setPrice(product.getPrice());

            productResponseDTOList.add(productResponseDTO);
        }
        productTypeResponseDTO.setProductResponseDTOList(productResponseDTOList);
        return productTypeResponseDTO;
    }

    public ProductType toEntity(ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType productType = new ProductType();
        productType.setProductTypeNo(productTypeRequestDTO.getProductTypeNo());
        productType.setProductTypeName(productTypeRequestDTO.getProductTypeName());
        return productType;
    }
}
