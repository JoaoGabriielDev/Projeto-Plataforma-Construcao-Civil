package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;

import java.util.UUID;

public interface FindClientByIdUseCase {

    Client execute(UUID id);
}