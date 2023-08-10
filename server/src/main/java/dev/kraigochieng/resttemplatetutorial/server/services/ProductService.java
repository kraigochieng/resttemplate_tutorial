package dev.kraigochieng.resttemplatetutorial.server.services;

import dev.kraigochieng.resttemplatetutorial.server.dto.ProductCreationDTO;
import dev.kraigochieng.resttemplatetutorial.server.dto.ProductDTO;
import dev.kraigochieng.resttemplatetutorial.server.models.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public ProductDTO postProduct(ProductCreationDTO productCreationDTO);
    public List<ProductDTO> getProducts();
    public ProductDTO getProduct(UUID productId);
}
