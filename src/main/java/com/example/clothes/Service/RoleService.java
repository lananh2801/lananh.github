package com.example.clothes.Service;

import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;

public interface RoleService {

    RoleResponseDTO addRole(RoleRequestDTO roleRequestDTO);
}
