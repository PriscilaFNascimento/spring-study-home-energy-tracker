package com.priscilafn.het_device_service.controller;

import com.priscilafn.het_device_service.dto.DeviceRequestDTO;
import com.priscilafn.het_device_service.dto.DeviceResponseDTO;
import com.priscilafn.het_device_service.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    public ResponseEntity<DeviceResponseDTO> createDevice(@RequestBody DeviceRequestDTO deviceRequestDto) {
        final DeviceResponseDTO deviceResponseDto = deviceService.createDevice(deviceRequestDto);

        return new ResponseEntity<>(deviceResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<DeviceResponseDTO>> getDevice(@PathVariable UUID id){
        final Optional<DeviceResponseDTO> deviceResponseDto = deviceService.getDeviceById(id);

        return ResponseEntity.ok(deviceResponseDto);
    }


    @PutMapping("{id}")
    public ResponseEntity<String> updateDevice(@PathVariable UUID id, @RequestBody DeviceRequestDTO deviceRequestDTO){
        try {
            deviceService.updateDevice(id, deviceRequestDTO);
            return ResponseEntity.ok("Device updated successfully!");
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("Device not found!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable UUID id){
        try{
            deviceService.deleteDevice(id);
            return ResponseEntity.ok("Device deleted successfully!");
        }catch (IllegalArgumentException e){
            return new ResponseEntity<>("Device not found!", HttpStatus.NOT_FOUND);
        }
    }
}
