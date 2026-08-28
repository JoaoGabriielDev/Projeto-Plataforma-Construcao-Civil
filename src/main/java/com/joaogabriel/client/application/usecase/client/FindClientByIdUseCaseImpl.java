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
public class FindClientByIdUseCaseImpl implements FindClientByIdUseCase{

    private final ClientRepository clientRepository;

    @Override
    public Client execute(UUID id) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        if (client.getStatus() == ClientStatus.INACTIVE) {
            throw new ClientNotFoundException(id);
        }

        return client;
    }
}
