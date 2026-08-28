package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;
import com.joaogabriel.client.domain.entity.ClientStatus;
import com.joaogabriel.client.domain.exception.ClientNotFoundException;
import com.joaogabriel.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteClientUseCaseImpl implements DeleteClientUseCase{

    private final ClientRepository clientRepository;

    @Override
    public void execute(UUID id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        if (client.getStatus() == ClientStatus.INACTIVE) {
            throw new ClientNotFoundException(id);
        }

        client.deactivate();

        clientRepository.save(client);
    }
}
