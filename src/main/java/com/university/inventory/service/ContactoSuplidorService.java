package com.university.inventory.service;

import com.university.inventory.dto.*;
import com.university.inventory.exception.*;
import com.university.inventory.model.*;
import com.university.inventory.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactoSuplidorService {

    private final SuplidorRepository suplidorRepo;
    private final ContactoSuplidorRepository contactoRepo;

    public ContactoSuplidorService(SuplidorRepository s, ContactoSuplidorRepository c) {
        this.suplidorRepo = s;
        this.contactoRepo = c;
    }

    @Transactional
    public ContactoSuplidorResponse crear(Long suplidorId, CrearContactoSuplidorRequest req) {
        Suplidor suplidor = suplidorRepo.findById(suplidorId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Suplidor no encontrado"));

        if (contactoRepo.existsBySuplidor_IdAndEmail(suplidorId, req.email())) {
            throw new ConflictoException("Ese email ya existe para este suplidor");
        }

        ContactoSuplidor c = new ContactoSuplidor();
        c.setSuplidor(suplidor);
        c.setNombres(req.nombres());
        c.setApellidos(req.apellidos());
        c.setEmail(req.email());
        c.setTelefono(req.telefono());
        c.setCargo(req.cargo());
        c.setEsPrincipal(Boolean.TRUE.equals(req.esPrincipal()));

        if (c.isEsPrincipal()) {
            suplidor.getContactos().forEach(x -> x.setEsPrincipal(false));
        }

        ContactoSuplidor guardado = contactoRepo.save(c);
        return map(guardado);
    }

    @Transactional
    public ContactoSuplidorResponse actualizar(Long suplidorId, Long contactoId, ActualizarContactoSuplidorRequest req) {
        ContactoSuplidor c = contactoRepo.findByIdAndSuplidor_Id(contactoId, suplidorId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Contacto no encontrado para este suplidor"));

        if (req.email() != null && !req.email().isBlank() && !req.email().equalsIgnoreCase(c.getEmail())) {
            if (contactoRepo.existsBySuplidor_IdAndEmail(suplidorId, req.email())) {
                throw new ConflictoException("Ese email ya existe para este suplidor");
            }
            c.setEmail(req.email());
        }

        if (req.nombres() != null)  c.setNombres(req.nombres());
        if (req.apellidos() != null) c.setApellidos(req.apellidos());
        if (req.telefono() != null) c.setTelefono(req.telefono());
        if (req.cargo() != null)    c.setCargo(req.cargo());

        if (req.esPrincipal() != null) {
            boolean esP = req.esPrincipal();
            c.setEsPrincipal(esP);
            if (esP) {
                c.getSuplidor().getContactos().forEach(x -> {
                    if (!x.getId().equals(c.getId())) x.setEsPrincipal(false);
                });
            }
        }
        return map(c);
    }

    private ContactoSuplidorResponse map(ContactoSuplidor c) {
        return new ContactoSuplidorResponse(
                c.getId(),
                c.getSuplidor().getId(),
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
