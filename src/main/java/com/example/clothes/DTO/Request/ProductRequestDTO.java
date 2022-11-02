package com.example.clothes.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestDTO {

    private Long productNo;
    private String productName;
    private BigDecimal price;
    private Long productTypeNo;
}
