package com.joaogabriel.client.application.usecase.client;

import com.joaogabriel.client.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindAllClientsUseCase {

    Page<Client> execute(Pageable pageable);
}
