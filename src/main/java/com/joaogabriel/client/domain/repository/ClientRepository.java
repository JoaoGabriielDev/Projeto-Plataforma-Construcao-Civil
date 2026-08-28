package com.joaogabriel.client.domain.repository;

import com.joaogabriel.client.domain.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository {

    Client save(Client client);

    Optional<Client> findById(UUID id);

    boolean existsByDocument(String document);

    Page<Client> findAllActive(Pageable pageable);
}