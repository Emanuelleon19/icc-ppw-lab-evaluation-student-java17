package ec.edu.ups.icc.libraryevaluation.books.dtos;

import java.math.BigDecimal;

public record BookResponseDto(
        Long id,
        String isbn,
        String title,
        String author,
        String category,
        Integer copiesAvailable,
        BigDecimal price,
        Boolean active
) {}
