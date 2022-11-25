package com.example.clothes.Service.Impl;

import com.example.clothes.Constants.ExceptionConstant;
import com.example.clothes.Convert.UserConvert;
import com.example.clothes.DTO.Request.UserRequestDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.Role;
import com.example.clothes.Entity.User;
import com.example.clothes.Exception.Exception;
import com.example.clothes.Exception.NotFoundException;
import com.example.clothes.Repository.OrderProductRepository;
import com.example.clothes.Repository.OrderRepository;
import com.example.clothes.Repository.RoleRepository;
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
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getRoleNo() != null) {
            Optional<Role> role = roleRepository.findById(userRequestDTO.getRoleNo());
            if (!role.isPresent()) {
                throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
            }
            User user = userConvert.toEntity(userRequestDTO);
            user.setAddressShip(userRequestDTO.getAddressShip());
            user.setPassword(userRequestDTO.getPassword());
            user.setRole(role.get());
            user = userRepository.save(user);

            UserResponseDTO userResponseDTO = userConvert.toDTO(user);
            userResponseDTO.setRoleName(user.getRole().getRoleName());
            return userResponseDTO;
        }
        return new UserResponseDTO();
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
                throw new NotFoundException(ExceptionConstant.USER_IS_NULL);
            }
            User user = userConvert.toEntity(userRequestDTO);
            user.setPassword(userRequestDTO.getPassword());
            user.setAddressShip(userRequestDTO.getAddressShip());
            userRepository.save(user);

            UserResponseDTO userResponseDTO = userConvert.toDTO(user);
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
        if (userRequestDTO.getRoleNo() == null ||
            userRequestDTO.getUserName() == null ||
            userRequestDTO.getPassword() == null) {
            throw new NotFoundException(ExceptionConstant.USER_NAME_OR_PASSWORD_OR_ROLE_IS_NULL);
        }
        Optional<Role> role = roleRepository.findById(userRequestDTO.getRoleNo());
        if (!role.isPresent()) {
            throw new NotFoundException(ExceptionConstant.ROLE_IS_NULL);
        }
        if ((userRepository.getUserByUserName(userRequestDTO.getUserName())) != null) {
            throw new Exception(ExceptionConstant.USER_NAME_IS_EXIST);
        }
        User user = userConvert.toEntity(userRequestDTO);
        user.setAddressShip(userRequestDTO.getAddressShip());
        user.setPassword(userRequestDTO.getPassword());
        user.setRole(role.get());
        userRepository.save(user);

        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        userResponseDTO.setRoleName(user.getRole().getRoleName());
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO login(UserRequestDTO userRequestDTO) {

        if (userRepository.getUserByUserName(userRequestDTO.getUserName()) == null ||
            userRepository.getUsersByPassword(userRequestDTO.getPassword()).isEmpty()) {
            throw new NotFoundException(ExceptionConstant.USER_NAME_OR_PASSWORD_IS_NOT_EXIST);
        }
        if (!userRepository.getUserByUserName(userRequestDTO.getUserName()).getPassword().equals(userRequestDTO.getPassword())) {
            throw new NotFoundException(ExceptionConstant.USER_NAME_OR_PASSWORD_IS_NOT_EXIST);
        }
        User user = userRepository.getUserByUserName(userRequestDTO.getUserName());
        UserResponseDTO userResponseDTO = userConvert.toDTO(user);
        userResponseDTO.setRoleName(user.getRole().getRoleName());
        return userResponseDTO;
    }
}
