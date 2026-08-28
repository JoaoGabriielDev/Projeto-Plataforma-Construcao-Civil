package com.joaogabriel.client.adapter.input.web.mapper;

import com.joaogabriel.client.adapter.input.web.dto.ClientCreateRequest;
import com.joaogabriel.client.adapter.input.web.dto.ClientUpdateRequest;
import com.joaogabriel.client.application.usecase.client.CreateClientCommand;
import com.joaogabriel.client.application.usecase.client.UpdateClientCommand;

public class ClientInputMapper {

    private ClientInputMapper() {
    }

    public static CreateClientCommand toCommand(ClientCreateRequest request) {

        return new CreateClientCommand(
                request.name(),
                request.document(),
                request.email(),
                request.phone(),
                request.address(),
                request.city(),
                request.state()
        );
    }

    public static UpdateClientCommand toCommand(ClientUpdateRequest request) {
        return new UpdateClientCommand(
                request.name(),
                request.document(),
                request.email(),
                request.phone(),
                request.address(),
                request.city(),
                request.state()
        );
    }
}