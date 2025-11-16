package com.university.inventory.contactSupplier.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

public record ActualizarContactoSuplidorRequest(
        String nombres,
        String apellidos,
        @Email String email,
        @Pattern(regexp = "^[0-9+()\\-\\s]*$", message = "Teléfono inválido") String telefono,
        String cargo,
        Boolean esPrincipal
) {}
