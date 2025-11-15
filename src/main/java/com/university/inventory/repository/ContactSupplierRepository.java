package com.university.inventory.repository;

import com.university.inventory.model.SupplierContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactSupplierRepository extends JpaRepository<SupplierContact, Long> {
    boolean existsBySuplidor_IdAndEmail(Long suplidorId, String email);
    Optional<SupplierContact> findByIdAndSuplidor_Id(Long contactoId, Long suplidorId);
}
