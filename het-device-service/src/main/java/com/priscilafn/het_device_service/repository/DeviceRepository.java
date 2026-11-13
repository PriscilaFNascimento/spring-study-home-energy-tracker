package com.priscilafn.het_device_service.repository;

import com.priscilafn.het_device_service.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
