package com.university.inventory.contactSupplier.repository;

import com.university.inventory.product.model.Product;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        update Product p
           set p.active = true
         where p.supplier.id = :supplierId
           and p.active = false
           and p.deleted = false
    """)
    int enableProductsBySupplier(@Param("supplierId") Long supplierId);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
        update Product p
           set p.active = false
         where p.supplier.id = :supplierId
           and p.active = true
           and p.deleted = false
    """)
    int disableProductsBySupplier(@Param("supplierId") Long supplierId);
}