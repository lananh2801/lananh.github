package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.ProductTypeConvert;
import com.example.clothes.DTO.Request.ProductTypeRequestDTO;
import com.example.clothes.DTO.Response.ProductTypeResponseDTO;
import com.example.clothes.Entity.ProductType;
import com.example.clothes.Repository.ProductRepository;
import com.example.clothes.Repository.ProductTypeRepository;
import com.example.clothes.Service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    ProductTypeRepository productTypeRepository;

    @Autowired
    ProductTypeConvert productTypeConvert;

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductTypeResponseDTO addProductType(ProductTypeRequestDTO productTypeRequestDTO) {
        ProductType productType = productTypeConvert.toEntity(productTypeRequestDTO);
        productType = productTypeRepository.save(productType);

        ProductTypeResponseDTO productTypeResponseDTO = productTypeConvert.toDTO(productType);
        return productTypeResponseDTO;
    }

    @Override
    public ProductTypeResponseDTO getProductType(Long id) {
         ProductType productType = productTypeRepository.findById(id).get();
        ProductTypeResponseDTO productTypeResponseDTO = productTypeConvert.toDTO(productType);
         return productTypeResponseDTO;
    }
    @Transactional
    @Override
    public void deleteProductType(Long id) {
        productRepository.deleteProductsById(id);
        productTypeRepository.deleteProductTypeById(id);
    }
}
