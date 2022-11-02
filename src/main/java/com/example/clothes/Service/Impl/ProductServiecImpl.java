package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.ProductConvert;
import com.example.clothes.DTO.Request.ProductRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.Entity.Product;
import com.example.clothes.Entity.ProductType;
import com.example.clothes.Repository.ProductRepository;
import com.example.clothes.Repository.ProductTypeRepository;
import com.example.clothes.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiecImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductConvert productConvert;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        Product product = productConvert.toEntity(productRequestDTO);
        ProductType productType = productTypeRepository.getById(productRequestDTO.getProductTypeNo());
        product.setProductType(productType);
        product = productRepository.save(product);

        ProductResponseDTO productResponseDTO = productConvert.toDTO(product);

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO getProduct(Long id) {
        Product product =  productRepository.getById(id);
        ProductResponseDTO productResponseDTO = productConvert.toDTO(product);
        return productResponseDTO;
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }
}