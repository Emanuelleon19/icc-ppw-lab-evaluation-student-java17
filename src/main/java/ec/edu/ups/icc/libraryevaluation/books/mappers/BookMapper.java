package ec.edu.ups.icc.libraryevaluation.books.mappers;

import ec.edu.ups.icc.libraryevaluation.books.dtos.BookResponseDto;
import ec.edu.ups.icc.libraryevaluation.books.entities.BookEntity;

public final class BookMapper {
    private BookMapper() {
    }

    public static BookResponseDto toResponse(BookEntity entity) {
        return new BookResponseDto(
                entity.getId(),
                entity.getIsbn(),
                entity.getTitle(),
                entity.getAuthor(),
                entity.getCategory(),
                entity.getCopiesAvailable(),
                entity.getPrice(),
                entity.isActive());
    }
}
