package com.joaogabriel.client.adapter.input.web;

import com.joaogabriel.client.adapter.input.web.dto.ClientCreateRequest;
import com.joaogabriel.client.adapter.input.web.dto.ClientResponse;
import com.joaogabriel.client.adapter.input.web.dto.ClientUpdateRequest;
import com.joaogabriel.client.adapter.input.web.mapper.ClientInputMapper;
import com.joaogabriel.client.adapter.input.web.mapper.ClientResponseMapper;
import com.joaogabriel.client.application.usecase.client.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientUseCase createClientUseCase;
    private final FindClientByIdUseCase findClientByIdUseCase;
    private final FindAllClientsUseCase findAllClientsUseCase;
    private final UpdateClientUseCase updateClientUseCase;
    private final DeleteClientUseCase deleteClientUseCase;

    @Operation(
            summary = "Create a client",
            description = "Creates a new client"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Client created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "409", description = "Document already registered")
    })
    @PostMapping
    public ResponseEntity<ClientResponse> create(
            @Valid @RequestBody ClientCreateRequest request) {

        var command = ClientInputMapper.toCommand(request);

        var client = createClientUseCase.execute(command);

        var response = ClientResponseMapper.toResponse(client);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @Operation(
            summary = "Find client by ID",
            description = "Returns an active client by its UUID"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client found"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable UUID id){

        var client = findClientByIdUseCase.execute(id);

        var response = ClientResponseMapper.toResponse(client);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "List active clients",
            description = "Returns a paginated list of active clients"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Clients retrieved successfully"
    )
    @GetMapping
    public ResponseEntity<Page<ClientResponse>> findAll(Pageable pageable) {

        var clients = findAllClientsUseCase.execute(pageable);

        var response = clients.map(ClientResponseMapper::toResponse);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Update a client",
            description = "Updates an existing client"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "409", description = "Document already registered")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update( @PathVariable UUID id,
                                                  @Valid @RequestBody ClientUpdateRequest request) {

        var command = ClientInputMapper.toCommand(request);

        var client = updateClientUseCase.execute(id, command);

        var response = ClientResponseMapper.toResponse(client);

        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = "Deactivate a client",
            description = "Performs a soft delete by changing the client status to INACTIVE"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Client deactivated successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {

        deleteClientUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }
}