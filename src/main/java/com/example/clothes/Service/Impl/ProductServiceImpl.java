package com.example.clothes.Service.Impl;

import com.example.clothes.Constants.ExceptionConstant;
import com.example.clothes.Convert.ProductConvert;
import com.example.clothes.DTO.Request.ProductRequestDTO;
import com.example.clothes.DTO.Response.ProductResponseDTO;
import com.example.clothes.Entity.Product;
import com.example.clothes.Entity.ProductType;
import com.example.clothes.Exception.NotFoundException;
import com.example.clothes.Repository.ProductRepository;
import com.example.clothes.Repository.ProductTypeRepository;
import com.example.clothes.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    ProductConvert productConvert;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO.getProductTypeNo() != null) {
            Optional<ProductType> productType = productTypeRepository.findById(productRequestDTO.getProductTypeNo());
            if (!productType.isPresent() ) {
                throw new NotFoundException(ExceptionConstant.PRODUCT_TYPE_IS_NULL);
            }
                Product product = productConvert.toEntity(productRequestDTO);
                product.setProductType(productType.get());
                product = productRepository.save(product);

                ProductResponseDTO productResponseDTO = productConvert.toDTO(product);

                return productResponseDTO;
        }
        return new ProductResponseDTO();
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

    @Override
    public ProductResponseDTO updateProduct(ProductRequestDTO productRequestDTO) {
        if (productRequestDTO.getProductNo() != null && productRequestDTO.getProductTypeNo() != null) {
            Optional<Product> productOptional = productRepository.findById(productRequestDTO.getProductNo());
            Optional<ProductType> productTypeOptional = productTypeRepository.findById(productRequestDTO.getProductTypeNo());
            if (!productOptional.isPresent() || !productTypeOptional.isPresent()) {
                throw new NotFoundException(ExceptionConstant.PRODUCT_TYPE_OR_PRODUCT_IS_NULL);
            }
            Product product = productConvert.toEntity(productRequestDTO);
            ProductType productType = productTypeOptional.get();
            product.setProductType(productType);

            productRepository.save(product);

            ProductResponseDTO productResponseDTO = productConvert.toDTO(product);
            return productResponseDTO;
        }
        return new ProductResponseDTO();
    }
}