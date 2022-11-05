package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.SupplierConvert;
import com.example.clothes.DTO.Request.SupplierRequestDTO;
import com.example.clothes.DTO.Response.SupplierResponseDTO;
import com.example.clothes.Entity.Supplier;
import com.example.clothes.Repository.SupplierRepository;
import com.example.clothes.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    private final SupplierConvert supplierConvert;

    @Override
    public SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = supplierConvert.toEntity(supplierRequestDTO);
        supplierRepository.save(supplier);

        SupplierResponseDTO supplierResponseDTO = supplierConvert.toDTO(supplier);
        return supplierResponseDTO;
    }
}
