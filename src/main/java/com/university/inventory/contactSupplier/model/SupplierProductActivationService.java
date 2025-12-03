package com.university.inventory.contactSupplier.model;

import com.university.inventory.contactSupplier.dto.SupplierProductActivationResponse;
import com.university.inventory.supplier.model.Supplier;
import com.university.inventory.contactSupplier.repository.ProductRepository;
import com.university.inventory.supplier.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SupplierProductActivationService {

    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final SupplierRepository supplierRepository;

    public SupplierProductActivationService(ProductRepository productRepository,
                                            SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public SupplierProductActivationResponse enableProductsBySupplier(UUID supplierId) {

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        int updated = productRepository.enableProductsBySupplier(supplier.getId());

        return new SupplierProductActivationResponse(
                supplier.getId(),
                true,
                updated
        );
    }

    public SupplierProductActivationResponse disableProductsBySupplier(UUID supplierId) {

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        int updated = productRepository.disableProductsBySupplier(supplier.getId());

        return new SupplierProductActivationResponse(
                supplier.getId(),
                false,
                updated
        );
    }
}