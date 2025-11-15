package com.university.inventory.service;

import com.university.inventory.exceptions.InformationExistsException;
import com.university.inventory.exceptions.NotFoundException;
import com.university.inventory.model.SupplierContact;
import com.university.inventory.dto.*;
import com.university.inventory.repository.ContactSupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ContactSupplierService {

    private final ContactSupplierRepository contactoRepo;

    public ContactSupplierService(ContactSupplierRepository c) {
        this.contactoRepo = c;
    }

    @Transactional
    public ContactSupplierResponse createNewContact(Long suplidorId, ContactSupplierRequest req) {

        var supplierContact = new SupplierContact();
        supplierContact.setNombres(req.nombres());
        supplierContact.setApellidos(req.apellidos());
        supplierContact.setEmail(req.email());
        supplierContact.setTelefono(req.telefono());
        supplierContact.setCargo(req.cargo());
        supplierContact.setEsPrincipal(Boolean.TRUE.equals(req.esPrincipal()));

        SupplierContact guardado = contactoRepo.save(supplierContact);
        return toDtoResponse(guardado);
    }

    @Transactional
    public ContactSupplierResponse updateInformation(Long suplidorId, Long contactoId, ContactSupplierRequest req) throws InformationExistsException, NotFoundException {
        SupplierContact c = contactoRepo.findByIdAndSuplidor_Id(contactoId, suplidorId)
                .orElseThrow(() -> new NotFoundException("Contacto no encontrado para este suplidor"));

        if (req.email() != null && !req.email().isBlank() && !req.email().equalsIgnoreCase(c.getEmail())) {
            if (contactoRepo.existsBySuplidor_IdAndEmail(suplidorId, req.email())) {
                throw new InformationExistsException("Ese email ya existe para este suplidor");
            }
            c.setEmail(req.email());
        }

        if (req.nombres() != null)  c.setNombres(req.nombres());
        if (req.apellidos() != null) c.setApellidos(req.apellidos());
        if (req.telefono() != null) c.setTelefono(req.telefono());
        if (req.cargo() != null)    c.setCargo(req.cargo());

       /* if (req.esPrincipal() != null) {
            boolean esP = req.esPrincipal();
            c.setEsPrincipal(esP);
            if (esP) {
                c.getSupplier().getContactos().forEach(x -> {
                    if (!x.getId().equals(c.getId())) x.setEsPrincipal(false);
                });
            }
        }*/
        return toDtoResponse(c);
    }

    private ContactSupplierResponse toDtoResponse(SupplierContact c) {
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
