package com.university.inventory.supplier.service;

import com.university.inventory.supplier.model.Supplier;
import java.util.List;
import java.util.UUID;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    List<Supplier> searchSuppliersByName(String name);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(UUID id);
}

