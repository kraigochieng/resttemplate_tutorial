package dev.kraigochieng.resttemplatetutorial.client.services;

import dev.kraigochieng.resttemplatetutorial.client.dto.ProductCreationDTO;
import dev.kraigochieng.resttemplatetutorial.client.dto.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public ProductDTO postProduct(ProductCreationDTO productCreationDTO);
    public List<ProductDTO> getProducts();
    public ProductDTO getProduct(UUID productId);
}
