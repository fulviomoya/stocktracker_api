package com.university.inventory.repository;

import com.university.inventory.model.ContactSupplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactoSuplidorRepository extends JpaRepository<ContactSupplier, Long> {
    boolean existsBySuplidor_IdAndEmail(Long suplidorId, String email);
    Optional<ContactSupplier> findByIdAndSuplidor_Id(Long contactoId, Long suplidorId);
}
