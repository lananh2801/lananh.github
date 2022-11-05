package com.example.clothes.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponseDTO {
    private Long roleNo;
    private String roleName;
    private List<UserResponseDTO> userResponseDTOList;
}
