package ec.edu.ups.icc.libraryevaluation.books.services;

import java.util.List;
import ec.edu.ups.icc.libraryevaluation.books.dtos.BookResponseDto;

public interface BookService {
  List<BookResponseDto> findCatalog(Integer minCopies);

  List<BookResponseDto> findLowStock(Integer maxCopies);

  BookResponseDto deactivate(Long id);
}
