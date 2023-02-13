package com.mycompany.inventoryservice.repository;

import com.mycompany.inventoryservice.model.Inventor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventorRepository extends JpaRepository<Inventor, Long> {
    Optional<Inventor> findBySkuCode(String skuCode);
}
