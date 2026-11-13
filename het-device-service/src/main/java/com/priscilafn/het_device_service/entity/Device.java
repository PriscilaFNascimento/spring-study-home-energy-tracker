package com.priscilafn.het_device_service.entity;

import com.priscilafn.het_device_service.model.DeviceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "device")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DeviceType type;

    private UUID userId;
}
