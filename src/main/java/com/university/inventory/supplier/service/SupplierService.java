package com.university.inventory.supplier.service;

import com.university.inventory.supplier.model.Supplier;
import java.util.List;

public interface SupplierService {
    Supplier createSupplier(Supplier supplier);
    List<Supplier> searchSuppliersByName(String name);
    List<Supplier> getAllSuppliers();
    Supplier getSupplierById(Long id);
}

