package com.example.clothes.Service.Impl;

import com.example.clothes.Constants.ExceptionConstant;
import com.example.clothes.Convert.RoleConvert;
import com.example.clothes.Convert.UserConvert;
import com.example.clothes.DTO.Request.RoleRequestDTO;
import com.example.clothes.DTO.Response.RoleResponseDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.Role;
import com.example.clothes.Entity.User;
import com.example.clothes.Exception.NotFoundException;
import com.example.clothes.Repository.RoleRepository;
import com.example.clothes.Repository.UserRepository;
import com.example.clothes.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleConvert roleConvert;
    private final UserRepository userRepository;
    private final UserConvert userConvert;

    @Override
    public RoleResponseDTO addRole(RoleRequestDTO roleRequestDTO) {
        Role role = roleConvert.toEntity(roleRequestDTO);
        roleRepository.save(role);

        RoleResponseDTO roleResponseDTO = roleConvert.toDTO(role);
        return roleResponseDTO;
    }

    @Override
    public RoleResponseDTO getRoleById(Long id) {
        if (id != null) {
            Optional<Role> roleOptional = roleRepository.findById(id);
            if (!roleOptional.isPresent()) {
                throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
            }
            List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
            List<User> users = userRepository.getUsersByRoleNo(id);
            for (User user : users) {
                UserResponseDTO userResponseDTO = userConvert.toDTO(user);
                userResponseDTO.setRoleName(user.getRole().getRoleName());
                userResponseDTOList.add(userResponseDTO);
            }
            RoleResponseDTO roleResponseDTO = roleConvert.toDTO(roleOptional.get());
            roleResponseDTO.setUserResponseDTOList(userResponseDTOList);
            return roleResponseDTO;
        }
        return new RoleResponseDTO();
    }

    @Override
    public RoleResponseDTO updateRole(RoleRequestDTO roleRequestDTO) {
        if (roleRequestDTO.getRoleNo() != null) {
           Optional<Role> roleGet = roleRepository.findById(roleRequestDTO.getRoleNo());
           if (!roleGet.isPresent()) {
               throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
           }
           Role role = roleConvert.toEntity(roleRequestDTO);
           roleRepository.save(role);

           RoleResponseDTO roleResponseDTO = roleConvert.toDTO(role);
           return roleResponseDTO;
        }
        return new RoleResponseDTO();
    }
}
