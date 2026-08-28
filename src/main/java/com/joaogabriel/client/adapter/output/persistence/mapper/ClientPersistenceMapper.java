package com.joaogabriel.client.adapter.output.persistence.mapper;

import com.joaogabriel.client.adapter.output.persistence.entity.ClientPersistenceEntity;
import com.joaogabriel.client.domain.entity.Client;

public class ClientPersistenceMapper {

    private ClientPersistenceMapper() {
    }

    public static ClientPersistenceEntity toEntity(Client client) {

        return ClientPersistenceEntity.builder()
                .id(client.getId())
                .name(client.getName())
                .document(client.getDocument())
                .email(client.getEmail())
                .phone(client.getPhone())
                .address(client.getAddress())
                .city(client.getCity())
                .state(client.getState())
                .createdAt(client.getCreatedAt())
                .status(client.getStatus())
                .build();
    }

    public static Client toDomain(ClientPersistenceEntity entity) {

        return Client.builder()
                .id(entity.getId())
                .name(entity.getName())
                .document(entity.getDocument())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .address(entity.getAddress())
                .city(entity.getCity())
                .state(entity.getState())
                .createdAt(entity.getCreatedAt())
                .status(entity.getStatus())
                .build();
    }
}