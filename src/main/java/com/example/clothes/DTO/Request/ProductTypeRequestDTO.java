package com.example.clothes.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductTypeRequestDTO {
    private Long productTypeNo;
    private String productTypeName;
}
