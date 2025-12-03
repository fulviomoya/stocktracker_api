package com.university.inventory.contactSupplier.service;

import com.university.inventory.exceptions.InformationExistsException;
import com.university.inventory.exceptions.NotFoundException;
import com.university.inventory.contactSupplier.model.SupplierContact;
import com.university.inventory.contactSupplier.dto.*;
import com.university.inventory.contactSupplier.repository.ContactSupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.university.inventory.contactSupplier.service.mapper.ContactSupplierMapper.toDtoResponse;


@Service
public class ContactSupplierService {

    @Autowired
    private final ContactSupplierRepository contactSupplierRepository;

    public ContactSupplierService(ContactSupplierRepository c) {
        this.contactSupplierRepository = c;
    }

    public ContactSupplierResponse createNewContact(Long suplidorId, ContactSupplierRequest req) {

        var supplierContact = new SupplierContact();
        supplierContact.setNombres(req.nombres());
        supplierContact.setApellidos(req.apellidos());
        supplierContact.setEmail(req.email());
        supplierContact.setTelefono(req.telefono());
        supplierContact.setCargo(req.cargo());
        supplierContact.setEsPrincipal(Boolean.TRUE.equals(req.esPrincipal()));

        SupplierContact guardado = contactSupplierRepository.save(supplierContact);
        return toDtoResponse(guardado);
    }

    public ContactSupplierResponse updateInformation(UUID suplidorId, UUID contactoId, ContactSupplierRequest req) throws InformationExistsException, NotFoundException {
        SupplierContact c = contactSupplierRepository.findByIdAndSupplier(contactoId, suplidorId)
                .orElseThrow(() -> new NotFoundException("Contacto no encontrado para este suplidor"));

        if (req.email() != null && !req.email().isBlank() && !req.email().equalsIgnoreCase(c.getEmail())) {
            if (contactSupplierRepository.existsBySupplierAndEmail(suplidorId, req.email())) {
                throw new InformationExistsException("Ese email ya existe para este suplidor");
            }
            c.setEmail(req.email());
        }

        if (req.nombres() != null)  c.setNombres(req.nombres());
        if (req.apellidos() != null) c.setApellidos(req.apellidos());
        if (req.telefono() != null) c.setTelefono(req.telefono());
        if (req.cargo() != null)    c.setCargo(req.cargo());

        return toDtoResponse(c);
    }


}
