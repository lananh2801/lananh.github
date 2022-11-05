package com.example.clothes.Convert;

import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.Role;
import com.example.clothes.Entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleConvert {

    public Role toEntity(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleNo(roleRequestDTO.getRoleNo());
        role.setRoleName(roleRequestDTO.getRoleName());
        return role;
    }

    public RoleResponseDTO toDTO(Role role) {
        RoleResponseDTO roleResponseDTO = new RoleResponseDTO();
        roleResponseDTO.setRoleNo(role.getRoleNo());
        roleResponseDTO.setRoleName(role.getRoleName());
        return roleResponseDTO;
    }
}
