package com.university.inventory.supplier.repository;

import com.university.inventory.supplier.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    
    List<Supplier> findByNameContainingIgnoreCase(String name);
    
    @Query("SELECT s FROM Supplier s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Supplier> searchByName(@Param("name") String name);
}

