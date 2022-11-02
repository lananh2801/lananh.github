package com.example.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderResponseDTO {

    private Long orderNo;
    private UserResponseDTO userResponseDTO;
    private List<ProductResponseDTO> productResponseDTOList;
    private BigDecimal amountOfMoney;
}
