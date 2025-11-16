package com.university.inventory.contactSupplier.service.mapper;

import com.university.inventory.contactSupplier.dto.ContactSupplierResponse;
import com.university.inventory.contactSupplier.model.SupplierContact;

public class ContactSupplierMapper {

    public static ContactSupplierResponse toDtoResponse(SupplierContact c) {
        return new ContactSupplierResponse(
                c.getId(),
                c.getNombres(),
                c.getApellidos(),
                c.getEmail(),
                c.getTelefono(),
                c.getCargo(),
                c.isEsPrincipal(),
                c.getCreadoEn(),
                c.getActualizadoEn()
        );
    }
}
