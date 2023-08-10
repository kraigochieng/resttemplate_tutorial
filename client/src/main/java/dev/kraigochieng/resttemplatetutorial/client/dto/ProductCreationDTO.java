package dev.kraigochieng.resttemplatetutorial.client.dto;

import java.math.BigDecimal;

public record ProductCreationDTO(
        String name,
        BigDecimal price
) {
}
