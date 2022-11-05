package com.example.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillImportResponseDTO {
    private Long billNo;
    private String content;
    private SupplierResponseDTO supplierResponseDTO;
    private UserResponseDTO userResponseDTO;
    private List<ProductResponseDTO> productResponseDTOList;
    private BigDecimal totalBill;
}
