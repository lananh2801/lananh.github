package com.example.clothes.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequestDTO {
    private Long orderNo;
    private Long userNo;
    private List<ProductRequestDTO> productRequestDTOS;

}
