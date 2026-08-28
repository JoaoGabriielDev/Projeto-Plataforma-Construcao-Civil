package com.joaogabriel.client.domain.exception;

public class ClientAlreadyExistsException extends RuntimeException {

    public ClientAlreadyExistsException(String document) {
        super("Client already exists with document: " + document);
    }
}