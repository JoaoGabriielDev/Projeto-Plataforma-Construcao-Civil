package com.joaogabriel.client.adapter.input.web.dto;

import com.joaogabriel.client.domain.entity.ClientStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponse(

        UUID id,
        String name,
        String document,
        String email,
        String phone,
        String address,
        String city,
        String state,
        LocalDateTime createdAt,
        ClientStatus status

) {
}