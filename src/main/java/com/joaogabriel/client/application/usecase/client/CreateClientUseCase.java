package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;

public interface CreateClientUseCase {

    Client execute(CreateClientCommand command);
}