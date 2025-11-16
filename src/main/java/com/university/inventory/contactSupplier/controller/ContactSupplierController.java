package com.university.inventory.contactSupplier.controller;


import com.university.inventory.exceptions.InformationExistsException;
import com.university.inventory.exceptions.NotFoundException;
import com.university.inventory.contactSupplier.service.ContactSupplierService;
import com.university.inventory.contactSupplier.dto.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/supplier/contacts")
public class ContactSupplierController {
    private final ContactSupplierService service;

    @Autowired
    public ContactSupplierController(ContactSupplierService service) {
        this.service = service;
    }

    // FIXME: set a path to this method
    @PostMapping
    public ResponseEntity<ContactSupplierResponse> createNewContact(
            @PathVariable Long suplidorId,
            @Valid @RequestBody ContactSupplierRequest request) {
        var resp = service.createNewContact(suplidorId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @PutMapping("/{contactoId}")
    public ContactSupplierResponse updateExistsContactInformation(
            @PathVariable Long suplidorId,
            @PathVariable Long contactoId,
            @Valid @RequestBody ContactSupplierRequest request) {
        try {
            return service.updateInformation(suplidorId, contactoId, request);
        } catch (InformationExistsException e) {
            throw new RuntimeException(e);
        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

