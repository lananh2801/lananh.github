package com.example.clothes.Controller;

import com.example.clothes.DTO.Request.UserRequestDTO;
import com.example.clothes.DTO.Response.UserResponseDTO;
import com.example.clothes.Entity.User;
import com.example.clothes.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("add-user")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }

    @GetMapping("get-user")
    public List<UserResponseDTO> getUser() {
        return userService.getUser();
    }

    @DeleteMapping("delete-user")
    public void deleteUser(@RequestParam Long userNo) {
        userService.deleteUser(userNo);
    }
}
