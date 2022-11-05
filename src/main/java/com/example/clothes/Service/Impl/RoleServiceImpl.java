package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.RoleConvert;
import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;
import com.example.clothes.Entity.Role;
import com.example.clothes.Repository.RoleRepository;
import com.example.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleConvert roleConvert;

    @Override
    public RoleResponseDTO addRole(RoleRequestDTO roleRequestDTO) {
        Role role = roleConvert.toEntity(roleRequestDTO);
        roleRepository.save(role);

        RoleResponseDTO roleResponseDTO = roleConvert.toDTO(role);
        return roleResponseDTO;
    }
}
