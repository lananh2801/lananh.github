package com.example.clothes.Service;

import com.example.clothes.DTO.Request.UserRequestDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.User;

import java.util.List;

public interface UserService {
    UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    List<UserResponseDTO> getUser();

    void deleteUser(Long userNo);
}
