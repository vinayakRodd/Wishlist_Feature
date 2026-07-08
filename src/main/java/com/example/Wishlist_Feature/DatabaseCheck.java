package com.example.Wishlist_Feature;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.Wishlist_Feature.repository.BondRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Component
public class DatabaseCheck implements CommandLineRunner {

    private final BondRepository bondRepository;

    @PersistenceContext
    private EntityManager entityManager; // Injecting the manager directly

    public DatabaseCheck(BondRepository bondRepository) {
        this.bondRepository = bondRepository;
    }

    @Override
    public void run(String... args) {
        try {
            long count = bondRepository.count();
            System.out.println("✅ Database Connection Successful! Total bonds: " + count);

            // Fetch table names safely
            List tables = entityManager
                    .createNativeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public'")
                    .getResultList();

            System.out.println("📋 Tables found in database: " + tables);

        } catch (Exception e) {
            System.err.println("❌ Database Connection Failed: " + e.getMessage());
        }
    }
}