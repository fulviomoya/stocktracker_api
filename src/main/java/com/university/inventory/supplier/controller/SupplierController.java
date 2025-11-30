package com.university.inventory.supplier.controller;

import com.university.inventory.supplier.model.Supplier;
import com.university.inventory.supplier.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    
    private final SupplierService supplierService;
    
    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }
    
    @PostMapping
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        try {
            Supplier createdSupplier = supplierService.createSupplier(supplier);
            return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Supplier>> searchSuppliersByName(@RequestParam String name) {
        try {
            List<Supplier> suppliers = supplierService.searchSuppliersByName(name);
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        try {
            List<Supplier> suppliers = supplierService.getAllSuppliers();
            return new ResponseEntity<>(suppliers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        try {
            Supplier supplier = supplierService.getSupplierById(id);
            return new ResponseEntity<>(supplier, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

