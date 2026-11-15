package com.priscilafn.het_user_service.service;

import com.priscilafn.het_user_service.dto.UserRequestDTO;
import com.priscilafn.het_user_service.dto.UserResponseDTO;
import com.priscilafn.het_user_service.entity.User;
import com.priscilafn.het_user_service.exception.UserNotFoundException;
import com.priscilafn.het_user_service.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {

        final User entity = User.builder()
                .name(userRequestDTO.name())
                .surname(userRequestDTO.surname())
                .email(userRequestDTO.email())
                .address(userRequestDTO.address())
                .hasAlertEnabled(userRequestDTO.hasAlertEnabled())
                .energyAlertingThreshold(userRequestDTO.energyAlertingThreshold())
                .build();

        userRepository.save(entity);

        return toResponseDTO(entity);
    }

    public Optional<UserResponseDTO> getUserById(UUID id) {
        return userRepository.findById(id)
                .map(this::toResponseDTO);
    }

    public void updateUser(UUID id, UserRequestDTO userRequestDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        user.setName(userRequestDTO.name());
        user.setSurname(userRequestDTO.surname());
        user.setEmail(userRequestDTO.email());
        user.setAddress(userRequestDTO.address());
        user.setHasAlertEnabled(userRequestDTO.hasAlertEnabled());
        user.setEnergyAlertingThreshold(userRequestDTO.energyAlertingThreshold());

        userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        userRepository.delete(user);
    }

    private UserResponseDTO toResponseDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getAddress(),
                user.isHasAlertEnabled(),
                user.getEnergyAlertingThreshold()
        );
    }
}
