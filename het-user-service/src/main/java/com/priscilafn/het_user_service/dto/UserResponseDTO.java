package com.priscilafn.het_user_service.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponseDTO(UUID id,
                              String name,
                              String surname,
                              String email,
                              String address,
                              boolean hasAlertEnabled,
                              double energyAlertingThreshold) {
}