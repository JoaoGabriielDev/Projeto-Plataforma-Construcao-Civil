package com.joaogabriel.client.adapter.input.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClientUpdateRequest(

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Document is required")
        String document,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email")
        String email,

        @NotBlank(message = "Phone is required")
        String phone,

        @NotBlank(message = "Address is required")
        String address,

        @NotBlank(message = "City is required")
        String city,

        @NotBlank(message = "State is required")
        @Size(min = 2, max = 2, message = "State must have 2 characters")
        String state

) {
}