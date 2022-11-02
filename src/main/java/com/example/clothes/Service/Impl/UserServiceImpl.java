package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.UserConvert;
import com.example.clothes.DTO.Request.UserRequestDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.User;
import com.example.clothes.Repository.UserRepository;
import com.example.clothes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConvert userConvert;

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        User user = userConvert.toEntity(userRequestDTO);
        user.setAddressShip(userRequestDTO.getAddressShip());
        user.setPassword(userRequestDTO.getPassword());
        user = userRepository.save(user);

        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getUser() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setUserNo(user.getUserNo());
            userResponseDTO.setUserName(user.getUserName());
            userResponseDTO.setGender(user.getGender());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
