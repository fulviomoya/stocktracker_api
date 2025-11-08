package com.university.inventory.service;

import com.university.inventory.model.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    List<Supplier> searchSuppliersByName(String name);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Long id);
}

