package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.BillImportRequestDTO;
import com.example.clothes.DTO.Response.BillImportResponseDTO;
import com.example.clothes.Service.BillImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BillImportController {

    private final BillImportService billImportService;

    @PostMapping("add-billimport")
    public BillImportResponseDTO addBillImport(@RequestBody BillImportRequestDTO billImportRequestDTO) {
        return billImportService.addBillImport(billImportRequestDTO);
    }
}
