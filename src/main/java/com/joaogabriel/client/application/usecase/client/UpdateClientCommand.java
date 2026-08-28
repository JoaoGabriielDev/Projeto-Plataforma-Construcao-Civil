package com.joaogabriel.client.application.usecase.client;

public record UpdateClientCommand(
        String name,
        String document,
        String email,
        String phone,
        String address,
        String city,
        String state
) {
}