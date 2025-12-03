package com.university.inventory.supplier.service;

import com.university.inventory.supplier.model.Supplier;
import com.university.inventory.supplier.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
    
    private final SupplierRepository supplierRepository;
    
    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }
    
    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
    
    @Override
    public List<Supplier> searchSuppliersByName(String name) {
        return supplierRepository.searchByName(name);
    }
    
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
    
    @Override
    public Supplier getSupplierById(UUID id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }
}

