package dev.kraigochieng.resttemplatetutorial.server.dto;

import dev.kraigochieng.resttemplatetutorial.server.models.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class ProductCreationDTOMapper implements Function<ProductCreationDTO, Product> {
    @Override
    public Product apply(ProductCreationDTO productCreationDTO) {
        return new Product(productCreationDTO.name(), productCreationDTO.price());
    }
}
