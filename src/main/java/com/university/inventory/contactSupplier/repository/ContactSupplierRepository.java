package com.university.inventory.contactSupplier.repository;

import com.university.inventory.contactSupplier.model.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContactSupplierRepository extends JpaRepository<SupplierContact, UUID> {
    boolean existsBySupplierAndEmail(UUID supplier, String email);
    Optional<SupplierContact> findByIdAndSupplier(UUID contactoId, UUID supplier);
}
