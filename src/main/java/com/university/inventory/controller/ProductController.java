package com.university.inventory.controller;

import com.university.inventory.model.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping ("Producto")
public class ProductController {


  package com.university.inventory.controller;

import com.university.inventory.dto.*;
import com.university.inventory.service.ContactoSuplidorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/suplidores/{suplidorId}/contactos")
    public class ContactoSuplidorController {

        private final ContactoSuplidorService service;

        public ContactoSuplidorController(ContactoSuplidorService service) {
            this.service = service;
        }

        @PostMapping
        public ResponseEntity<ContactoSuplidorResponse> crearContacto(
                @PathVariable Long suplidorId,
                @Valid @RequestBody CrearContactoSuplidorRequest request) {
            var resp = service.crear(suplidorId, request);
            return ResponseEntity.status(HttpStatus.CREATED).body(resp);
        }

        @PutMapping("/{contactoId}")
        public ContactoSuplidorResponse actualizarContacto(
                @PathVariable Long suplidorId,
                @PathVariable Long contactoId,
                @Valid @RequestBody ActualizarContactoSuplidorRequest request) {
            return service.actualizar(suplidorId, contactoId, request);
        }
    }

}
