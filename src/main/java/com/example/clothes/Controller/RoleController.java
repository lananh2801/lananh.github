package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;
import com.example.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("add-role")
    public RoleResponseDTO addRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return roleService.addRole(roleRequestDTO);
    }
}