package ec.edu.ups.icc.libraryevaluation.books.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.libraryevaluation.books.entities.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
        List<BookEntity> findByActiveTrueAndDeletedFalseAndCopiesAvailableGreaterThanEqualOrderByTitleAsc(
                        Integer minCopies);

        List<BookEntity> findByActiveTrueAndDeletedFalseAndCopiesAvailableLessThanOrderByCopiesAvailableAsc(
                        Integer maxCopies);

        Optional<BookEntity> findByIdAndDeletedFalse(Long id);
}
