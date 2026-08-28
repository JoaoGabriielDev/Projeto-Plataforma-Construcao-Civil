package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;
import com.joaogabriel.client.domain.exception.ClientAlreadyExistsException;
import com.joaogabriel.client.domain.exception.ClientNotFoundException;
import com.joaogabriel.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateClientUseCaseImpl implements UpdateClientUseCase {

    private final ClientRepository clientRepository;

    @Override
    public Client execute(UUID id, UpdateClientCommand command) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        boolean documentChanged =
                !client.getDocument().equals(command.document());

        if (documentChanged &&
                clientRepository.existsByDocument(command.document())) {

            throw new ClientAlreadyExistsException(command.document());
        }

        client.update(
                command.name(),
                command.document(),
                command.email(),
                command.phone(),
                command.address(),
                command.city(),
                command.state()
        );

        return clientRepository.save(client);
    }
}
