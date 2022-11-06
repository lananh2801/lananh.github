package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;
import com.example.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("add-role")
    public RoleResponseDTO addRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return roleService.addRole(roleRequestDTO);
    }

    @GetMapping("get-role")
    public RoleResponseDTO getRoleById(@RequestParam Long id) {
        return roleService.getRoleById(id);
    }

    @PutMapping("update-role")
    public RoleResponseDTO updateRole(@RequestBody RoleRequestDTO roleRequestDTO) {
        return roleService.updateRole(roleRequestDTO);
    }
}
