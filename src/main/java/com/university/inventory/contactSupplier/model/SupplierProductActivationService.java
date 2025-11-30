package com.university.inventory.contactSupplier.model;

import com.university.inventory.contactSupplier.dto.SupplierProductActivationResponse;
import com.university.inventory.supplier.model.Supplier;
import com.university.inventory.contactSupplier.repository.ProductRepository;
import com.university.inventory.supplier.repository.SupplierRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class SupplierProductActivationService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public SupplierProductActivationService(ProductRepository productRepository,
                                            SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public SupplierProductActivationResponse enableProductsBySupplier(Long supplierId) {

        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        int updated = productRepository.enableProductsBySupplier(supplier.getId());

        return new SupplierProductActivationResponse(
                supplier.getId(),
                true,
                updated
        );
    }

    @Transactional
    public SupplierProductActivationResponse disableProductsBySupplier(Long supplierId) {

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