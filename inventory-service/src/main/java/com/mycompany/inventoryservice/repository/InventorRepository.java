package com.mycompany.inventoryservice.repository;

import com.mycompany.inventoryservice.model.Inventor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventorRepository extends JpaRepository<Inventor, Long> {
}
