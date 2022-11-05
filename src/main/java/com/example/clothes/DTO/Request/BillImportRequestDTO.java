package com.example.clothes.DTO.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BillImportRequestDTO {
    private Long billNo;
    private String content;
    private Long supplierNo;
    private Long userNo;
    private List<ProductRequestDTO> productRequestDTOList;
}
