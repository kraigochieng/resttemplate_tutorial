package dev.kraigochieng.resttemplatetutorial.client.services;

import dev.kraigochieng.resttemplatetutorial.client.dto.ProductCreationDTO;
import dev.kraigochieng.resttemplatetutorial.client.dto.ProductDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    // Getting server UR>
    @Value("${baseURL}")
    public String baseURL;
    // Getting product URL
    public  String productURL;
    @PostConstruct
    protected void init() {
        this.productURL = baseURL + "products/";
    }
    @Autowired
    RestTemplate restTemplate;

    @Override
    public ProductDTO postProduct(ProductCreationDTO productCreationDTO) {
        // Set Content Type
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        // Set Http Entity
        HttpEntity<?> httpEntity = new HttpEntity<>(productCreationDTO,httpHeaders);
        // Call From server
        ResponseEntity<ProductDTO> response = restTemplate.exchange(
                productURL + "post",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<ProductDTO>() {}
        );
        return response.getBody();
    }

    @Override
    public List<ProductDTO> getProducts() {
        // Set Content Type
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // Set Http Entity
        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
        // Get From server
        ResponseEntity<List<ProductDTO>> response = restTemplate.exchange(
                productURL + "get",
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<List<ProductDTO>>() {}
        );
        // Return
        return response.getBody();
    }

    @Override
    public ProductDTO getProduct(UUID productId) {
        // Putting the variables in the new string
        String productURLWithVariables = productURL + "get/{productId}";
        productURLWithVariables = productURLWithVariables.replace("{productId}", productId.toString());

        // Set Content Type
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        // Set Http Entity
        HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);

        // Get From server
        ResponseEntity<ProductDTO> response = restTemplate.exchange(
                productURLWithVariables,
                HttpMethod.GET,
                httpEntity,
                new ParameterizedTypeReference<ProductDTO>() {}
        );
        // Return
        return response.getBody();

    }
}
