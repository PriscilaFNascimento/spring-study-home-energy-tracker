package com.priscilafn.het_user_service.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public record UserRequestDTO(String name,
                             String surname,
                             String email,
                             String address,
                             boolean hasAlertEnabled,
                             double energyAlertingThreshold) {
}
