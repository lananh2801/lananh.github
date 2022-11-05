package com.example.clothes.Service;

import com.example.clothes.DTO.Request.SupplierRequestDTO;
import com.example.clothes.DTO.Response.SupplierResponseDTO;

public interface SupplierService {
    SupplierResponseDTO addSupplier(SupplierRequestDTO supplierRequestDTO);
}
