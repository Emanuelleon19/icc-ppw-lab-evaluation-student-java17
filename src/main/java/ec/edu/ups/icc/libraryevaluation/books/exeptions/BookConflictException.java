package ec.edu.ups.icc.libraryevaluation.books.exeptions;

import ec.edu.ups.icc.libraryevaluation.core.exceptions.base.ApplicationException;
import org.springframework.http.HttpStatus;

public class BookConflictException extends ApplicationException {
  public BookConflictException(String message) {
    super(HttpStatus.CONFLICT, "BOOK_CONFLICT", message);
  }
}
