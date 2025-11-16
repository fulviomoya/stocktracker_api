package com.university.inventory.contactSupplier.dto;

import java.time.LocalDateTime;

public record ContactSupplierResponse(Long id, String nombres, String apellidos, String email, String telefono,
                                      String cargo, boolean esPrincipal, LocalDateTime creadoEn,
                                      LocalDateTime actualizadoEn){

}