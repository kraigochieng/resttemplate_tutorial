package dev.kraigochieng.resttemplatetutorial.client.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductDTO(
        UUID id,
        String name,
        BigDecimal price
) {
}
