package com.example.clothes.Service.Impl;

import com.example.clothes.Convert.UserConvert;
import com.example.clothes.DTO.Request.UserRequestDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.User;
import com.example.clothes.Exception.NotFoundException;
import com.example.clothes.Repository.OrderProductRepository;
import com.example.clothes.Repository.OrderRepository;
import com.example.clothes.Repository.UserRepository;
import com.example.clothes.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    UserConvert userConvert;

    private final OrderRepository orderRepository;

    private final OrderProductRepository orderProductRepository;
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
    @Transactional
    @Override
    public void deleteUser(Long userNo) {
        orderProductRepository.deleteOrderProductsByUserNo(userNo);
        orderRepository.deleteUserByUserNo(userNo);
        userRepository.deleteByUserNo(userNo);
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getUserNo() != null) {
            Optional<User> userOptional = userRepository.findById(userRequestDTO.getUserNo());
            if (!userOptional.isPresent()) {
                throw new NotFoundException("User is null");
            }
            User user = userOptional.get();
            user = userConvert.toEntity(userRequestDTO);
            user.setPassword(userRequestDTO.getPassword());
            user.setAddressShip(userRequestDTO.getAddressShip());
            userRepository.save(user);

            UserResponseDTO userResponseDTO = userConvert.toDTO(user);
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }
}
