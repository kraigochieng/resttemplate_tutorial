package dev.kraigochieng.resttemplatetutorial.server.dto;

import dev.kraigochieng.resttemplatetutorial.server.models.Product;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
