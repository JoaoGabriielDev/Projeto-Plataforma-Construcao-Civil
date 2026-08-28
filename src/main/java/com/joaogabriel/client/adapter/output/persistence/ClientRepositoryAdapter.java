package com.joaogabriel.client.adapter.output.persistence;

import com.joaogabriel.client.adapter.output.persistence.mapper.ClientPersistenceMapper;
import com.joaogabriel.client.adapter.output.persistence.repository.ClientJpaRepository;
import com.joaogabriel.client.domain.entity.Client;
import com.joaogabriel.client.domain.entity.ClientStatus;
import com.joaogabriel.client.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientJpaRepository repository;

    @Override
    public Client save(Client client) {

        var entity = ClientPersistenceMapper.toEntity(client);

        var savedEntity = repository.save(entity);

        return ClientPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Client> findById(UUID id) {

        return repository.findById(id)
                .map(ClientPersistenceMapper::toDomain);
    }

    @Override
    public Page<Client> findAllActive(Pageable pageable) {

        return repository
                .findAllByStatus(ClientStatus.ACTIVE, pageable)
                .map(ClientPersistenceMapper::toDomain);
    }

    @Override
    public boolean existsByDocument(String document) {

        return repository.existsByDocument(document);
    }

}