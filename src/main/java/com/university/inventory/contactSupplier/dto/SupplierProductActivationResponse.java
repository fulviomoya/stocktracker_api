package com.university.inventory.contactSupplier.dto;

import java.util.UUID;

public record SupplierProductActivationResponse(
        UUID supplierId,
        boolean active,
        int updatedProducts
) { }