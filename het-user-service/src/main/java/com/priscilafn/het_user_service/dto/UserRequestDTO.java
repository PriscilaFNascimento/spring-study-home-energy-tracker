package com.priscilafn.het_user_service.dto;

import java.util.UUID;

public record UserRequestDTO(String name,
                             String surname,
                             String email,
                             String address,
                             boolean hasAlertEnabled,
                             double energyAlertingThreshold) {
}
