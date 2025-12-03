package com.university.inventory.contactSupplier.controller;

import com.university.inventory.contactSupplier.dto.SupplierProductActivationResponse;
import com.university.inventory.contactSupplier.model.SupplierProductActivationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierProductActivationController {

    private final SupplierProductActivationService activationService;

    public SupplierProductActivationController(SupplierProductActivationService activationService) {
        this.activationService = activationService;
    }

    @PatchMapping("/{supplierId}/products/enable")
    public ResponseEntity<SupplierProductActivationResponse> enableProducts(
            @PathVariable UUID supplierId) {

        SupplierProductActivationResponse response =
                activationService.enableProductsBySupplier(supplierId);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{supplierId}/products/disable")
    public ResponseEntity<SupplierProductActivationResponse> disableProducts(
            @PathVariable UUID supplierId) {

        SupplierProductActivationResponse response =
                activationService.disableProductsBySupplier(supplierId);

        return ResponseEntity.ok(response);
    }
}