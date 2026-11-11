package com.priscilafn.het_user_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "application_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String surname;
    private String email;
    private String address;
    private boolean hasAlertEnabled;
    private double energyAlertingThreshold;
}
