package com.university.inventory.contactSupplier.dto;

public record SupplierProductActivationResponse(
        Long supplierId,
        boolean active,
        int updatedProducts
) { }