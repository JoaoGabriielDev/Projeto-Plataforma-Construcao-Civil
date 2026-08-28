package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;
import com.joaogabriel.client.domain.entity.ClientStatus;
import com.joaogabriel.client.domain.exception.ClientAlreadyExistsException;
import com.joaogabriel.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private final ClientRepository clientRepository;

    @Override
    public Client execute(CreateClientCommand command) {

        if (clientRepository.existsByDocument(command.document())) {
            throw new ClientAlreadyExistsException(command.document());
        }

        Client client = Client.builder()
                .name(command.name())
                .document(command.document())
                .email(command.email())
                .phone(command.phone())
                .address(command.address())
                .city(command.city())
                .state(command.state())
                .createdAt(LocalDateTime.now())
                .status(ClientStatus.ACTIVE)
                .build();

        return clientRepository.save(client);
    }
}