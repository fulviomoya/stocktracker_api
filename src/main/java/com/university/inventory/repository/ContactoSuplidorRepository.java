package com.university.inventory.repository;

import com.university.inventory.model.ContactoSuplidor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactoSuplidorRepository extends JpaRepository<ContactoSuplidor, Long> {
    boolean existsBySuplidor_IdAndEmail(Long suplidorId, String email);
    Optional<ContactoSuplidor> findByIdAndSuplidor_Id(Long contactoId, Long suplidorId);
}
