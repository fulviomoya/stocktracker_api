package com.university.inventory.dto;

import java.time.LocalDateTime;

public record ContactoSuplidorResponse(Long id, String nombres, String apellidos, String email, String telefono,
                                       String cargo, boolean esPrincipal, LocalDateTime creadoEn,
                                       LocalDateTime actualizadoEn){

}
