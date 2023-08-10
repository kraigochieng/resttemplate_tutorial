package dev.kraigochieng.resttemplatetutorial.server.repositories;

import dev.kraigochieng.resttemplatetutorial.server.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
