package dev.kraigochieng.resttemplatetutorial.server.services;

import dev.kraigochieng.resttemplatetutorial.server.dto.ProductCreationDTO;
import dev.kraigochieng.resttemplatetutorial.server.dto.ProductCreationDTOMapper;
import dev.kraigochieng.resttemplatetutorial.server.dto.ProductDTO;
import dev.kraigochieng.resttemplatetutorial.server.dto.ProductDTOMapper;
import dev.kraigochieng.resttemplatetutorial.server.models.Product;
import dev.kraigochieng.resttemplatetutorial.server.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDTOMapper productDTOMapper;

    @Autowired
    ProductCreationDTOMapper productCreationDTOMapper;
    @Override
    public ProductDTO postProduct(ProductCreationDTO productCreationDTO) {
        // Create product
        Product product = productCreationDTOMapper.apply(productCreationDTO);
        // Persist to database and return a dto object
        return productDTOMapper.apply(
                productRepository.save(product)
        );
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.findAll().stream()
                .map(productDTOMapper)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(UUID productId) {
        return productRepository
                .findById(productId)
                .map(productDTOMapper)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
}
