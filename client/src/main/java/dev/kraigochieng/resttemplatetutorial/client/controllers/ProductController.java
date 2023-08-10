package dev.kraigochieng.resttemplatetutorial.client.controllers;

import dev.kraigochieng.resttemplatetutorial.client.dto.ProductCreationDTO;
import dev.kraigochieng.resttemplatetutorial.client.dto.ProductDTO;
import dev.kraigochieng.resttemplatetutorial.client.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/products2")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProducts());
    }

    @GetMapping(path = "get/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<ProductDTO> getProduct(@PathVariable UUID productId) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProduct(productId));
    }
    @PostMapping(path = "post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> postProduct(@RequestBody ProductCreationDTO product) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.postProduct(product));
    }

}
