package com.priscilafn.het_device_service.service;

import com.priscilafn.het_device_service.dto.DeviceRequestDTO;
import com.priscilafn.het_device_service.dto.DeviceResponseDTO;
import com.priscilafn.het_device_service.entity.Device;
import com.priscilafn.het_device_service.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceResponseDTO createDevice(DeviceRequestDTO deviceRequestDto) {
        final Device entity = Device.builder()
                .name(deviceRequestDto.name())
                .location(deviceRequestDto.location())
                .type(deviceRequestDto.type())
                .userId(deviceRequestDto.userId())
                .build();

        deviceRepository.save(entity);

        return toResponseDto(entity);
    }

    public Optional<DeviceResponseDTO> getDeviceById(UUID id){
        return deviceRepository.findById(id)
                .map(this::toResponseDto);
    }


    public void updateDevice(UUID id, DeviceRequestDTO deviceRequestDTO) {
        final Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found!"));

        device.setName(deviceRequestDTO.name());
        device.setLocation(deviceRequestDTO.location());
        device.setType(deviceRequestDTO.type());

        deviceRepository.save(device);
    }

    public void deleteDevice(UUID id) {
        final Device device = deviceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Device not found!"));

        deviceRepository.delete(device);
    }

    private DeviceResponseDTO toResponseDto(Device entity){
        return new DeviceResponseDTO(
                entity.getId(),
                entity.getName(),
                entity.getLocation(),
                entity.getType(),
                entity.getUserId()
        );
    }
}
