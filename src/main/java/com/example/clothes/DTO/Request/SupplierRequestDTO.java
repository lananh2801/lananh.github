package com.example.clothes.DTO.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierRequestDTO {
    private Long supplierNo;
    private String supplierName;
    private String phoneNumber;
    private String address;
}
