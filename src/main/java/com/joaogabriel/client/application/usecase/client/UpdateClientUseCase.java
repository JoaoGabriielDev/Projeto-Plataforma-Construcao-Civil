package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;

import java.util.UUID;

public interface UpdateClientUseCase {

    Client execute(UUID id, UpdateClientCommand command);
}
