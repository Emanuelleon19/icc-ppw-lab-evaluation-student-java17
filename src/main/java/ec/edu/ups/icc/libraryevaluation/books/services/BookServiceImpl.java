package ec.edu.ups.icc.libraryevaluation.books.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.ups.icc.libraryevaluation.books.dtos.BookResponseDto;
import ec.edu.ups.icc.libraryevaluation.books.entities.BookEntity;
import ec.edu.ups.icc.libraryevaluation.books.exeptions.BookConflictException;
import ec.edu.ups.icc.libraryevaluation.books.mappers.BookMapper;
import ec.edu.ups.icc.libraryevaluation.books.repositories.BookRepository;
import ec.edu.ups.icc.libraryevaluation.core.exceptions.domain.NotFoundException;

@Service
public class BookServiceImpl implements BookService {
  private final BookRepository repository;

  public BookServiceImpl(BookRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<BookResponseDto> findCatalog(Integer minCopies) {
    return repository.findByActiveTrueAndDeletedFalseAndCopiesAvailableGreaterThanEqualOrderByTitleAsc(minCopies)
        .stream()
        .map(BookMapper::toResponse)
        .toList();
  }

  @Override
  @Transactional(readOnly = true)
  public List<BookResponseDto> findLowStock(Integer maxCopies) {
    return repository.findByActiveTrueAndDeletedFalseAndCopiesAvailableLessThanOrderByCopiesAvailableAsc(maxCopies)
        .stream()
        .map(BookMapper::toResponse)
        .toList();
  }

  @Override
  @Transactional
  public BookResponseDto deactivate(Long id) {
    BookEntity book = repository.findByIdAndDeletedFalse(id)
        .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND", "not found book"));

    if (book.getCopiesAvailable() > 0) {
      throw new BookConflictException("exception");
    }

    book.setActive(false);
    book.setDeleted(true);
    return BookMapper.toResponse(repository.save(book));
  }
}
