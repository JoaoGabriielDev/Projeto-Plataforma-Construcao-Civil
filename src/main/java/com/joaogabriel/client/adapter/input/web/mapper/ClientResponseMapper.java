package com.joaogabriel.client.adapter.input.web.mapper;

import com.joaogabriel.client.adapter.input.web.dto.ClientResponse;
import com.joaogabriel.client.domain.entity.Client;

public class ClientResponseMapper {

    private ClientResponseMapper() {
    }

    public static ClientResponse toResponse(Client client) {

        return new ClientResponse(
                client.getId(),
                client.getName(),
                client.getDocument(),
                client.getEmail(),
                client.getPhone(),
                client.getAddress(),
                client.getCity(),
                client.getState(),
                client.getCreatedAt(),
                client.getStatus()
        );
    }
}