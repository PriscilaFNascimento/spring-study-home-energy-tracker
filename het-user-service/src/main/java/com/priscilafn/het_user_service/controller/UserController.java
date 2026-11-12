package com.priscilafn.het_user_service.controller;

import com.priscilafn.het_user_service.dto.UserRequestDTO;
import com.priscilafn.het_user_service.dto.UserResponseDTO;
import com.priscilafn.het_user_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return new ResponseEntity<>(userResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserResponseDTO>> getUser(@PathVariable UUID id){
        Optional<UserResponseDTO> userResponseDTO = userService.getUserById(id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable UUID id, @RequestBody UserRequestDTO userRequestDTO){
        try {
            userService.updateUser(id, userRequestDTO);
            return ResponseEntity.ok("User updated successfully!");
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id){
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully!");
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }
}
