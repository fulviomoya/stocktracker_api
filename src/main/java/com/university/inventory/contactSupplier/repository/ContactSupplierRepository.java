package com.university.inventory.contactSupplier.repository;

import com.university.inventory.contactSupplier.model.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactSupplierRepository extends JpaRepository<SupplierContact, Long> {
    boolean existsBySuplidor_IdAndEmail(Long suplidorId, String email);
    Optional<SupplierContact> findByIdAndSuplidor_Id(Long contactoId, Long suplidorId);
}
