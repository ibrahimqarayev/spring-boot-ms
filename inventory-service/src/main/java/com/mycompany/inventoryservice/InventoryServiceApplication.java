package com.mycompany.inventoryservice;

import com.mycompany.inventoryservice.model.Inventor;
import com.mycompany.inventoryservice.repository.InventorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventorRepository inventorRepository) {
        return args -> {
            Inventor inventor1 = new Inventor();
            inventor1.setSkuCode("Iphone_13");
            inventor1.setQuantity(100);

            Inventor inventor2 = new Inventor();
            inventor2.setSkuCode("Iphone_13 red");
            inventor2.setQuantity(0);

            inventorRepository.save(inventor1);
            inventorRepository.save(inventor2);

        };
    }

}
