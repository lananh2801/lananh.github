package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.SupplierRequestDTO;
import com.example.clothes.DTO.Response.SupplierResponseDTO;
import com.example.clothes.Service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("add-supplier")
    public SupplierResponseDTO addSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO) {
        return supplierService.addSupplier(supplierRequestDTO);
    }
}
