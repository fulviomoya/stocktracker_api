package com.university.inventory.contactSupplier.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContactSupplierResponse(UUID id, String nombres, String apellidos, String email, String telefono,
                                      String cargo, boolean esPrincipal, LocalDateTime creadoEn,
                                      LocalDateTime actualizadoEn){

}