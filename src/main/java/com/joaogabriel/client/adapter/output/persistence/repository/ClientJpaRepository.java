package com.joaogabriel.client.adapter.output.persistence.repository;

import com.joaogabriel.client.adapter.output.persistence.entity.ClientPersistenceEntity;
import com.joaogabriel.client.domain.entity.ClientStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientJpaRepository
        extends JpaRepository<ClientPersistenceEntity, UUID> {

    boolean existsByDocument(String document);

    Page<ClientPersistenceEntity> findAllByStatus(
            ClientStatus status,
            Pageable pageable
    );

}