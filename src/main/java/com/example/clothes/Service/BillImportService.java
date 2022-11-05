package com.example.clothes.Service;

import com.example.clothes.DTO.Request.BillImportRequestDTO;
import com.example.clothes.DTO.Response.BillImportResponseDTO;

public interface BillImportService {

    BillImportResponseDTO addBillImport(BillImportRequestDTO billImportRequestDTO);
}
