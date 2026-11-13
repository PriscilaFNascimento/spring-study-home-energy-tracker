package com.priscilafn.het_device_service.dto;

import com.priscilafn.het_device_service.model.DeviceType;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeviceResponseDTO(UUID id, String name, String location, DeviceType type, UUID userId) {
}
