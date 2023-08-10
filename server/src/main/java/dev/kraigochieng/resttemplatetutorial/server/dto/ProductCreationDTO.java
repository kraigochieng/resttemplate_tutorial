package dev.kraigochieng.resttemplatetutorial.server.dto;

import java.math.BigDecimal;

public record ProductCreationDTO(
        String name,
        BigDecimal price
) {
}
