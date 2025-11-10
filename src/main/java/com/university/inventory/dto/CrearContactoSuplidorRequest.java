package com.university.inventory.dto;

import jakarta.validation.constraints.*;

public record CrearContactoSuplidorRequest(
        @NotBlank String nombres,
        @NotBlank String apellidos,
        @NotBlank @Email String email,
        @Pattern(regexp = "^[0-9+()\\-\\s]*$", message = "Teléfono inválido")
        String telefono,
        String cargo,
        Boolean esPrincipal
) {}
