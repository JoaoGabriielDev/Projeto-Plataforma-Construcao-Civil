package com.joaogabriel.client.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
public class Client {

    private UUID id;
    private String name;
    private String document;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private LocalDateTime createdAt;
    private ClientStatus status;

    public void activate() {
        this.status = ClientStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = ClientStatus.INACTIVE;
    }

    public void update(
            String name,
            String document,
            String email,
            String phone,
            String address,
            String city,
            String state
    ) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
    }
}
