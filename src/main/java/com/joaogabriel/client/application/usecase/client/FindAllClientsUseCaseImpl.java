package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;
import com.joaogabriel.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindAllClientsUseCaseImpl implements FindAllClientsUseCase{

    private final ClientRepository clientRepository;

    @Override
    public Page<Client> execute(Pageable pageable) {
        return clientRepository.findAllActive(pageable);
    }
}
