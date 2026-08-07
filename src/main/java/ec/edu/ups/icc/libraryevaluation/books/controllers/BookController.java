package ec.edu.ups.icc.libraryevaluation.books.controllers;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.ups.icc.libraryevaluation.books.dtos.BookResponseDto;
import ec.edu.ups.icc.libraryevaluation.books.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/books")
@Tag(name = "Books", description = "Consultas sobre libros")
public class BookController {
  private final BookService service;

  public BookController(BookService service) {
    this.service = service;
  }

  @GetMapping("/catalog")
  @Operation(summary = "Listar catálogo de libros")
  @ApiResponse(responseCode = "200", description = "Catálogo obtenido")
  public List<BookResponseDto> findCatalog(
      @Parameter(description = "Cantidad mínima de copias", example = "4") @RequestParam(defaultValue = "0") Integer minCopies) {
    return service.findCatalog(minCopies);
  }

  @GetMapping("/low-stock")
  @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
  @SecurityRequirement(name = "bearerAuth")
  @Operation(summary = "Listar libros")
  @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
  public List<BookResponseDto> findLowStock(
      @Parameter(description = "Cantidad máxima de copias", example = "4") @RequestParam(defaultValue = "4") Integer maxCopies) {
    return service.findLowStock(maxCopies);
  }

  @PatchMapping("/{id}/deactivate")
  @PreAuthorize("hasRole('ADMIN')")
  @SecurityRequirement(name = "bearerAuth")
  @Operation(summary = "Desactivar un libro")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "Libro desactivado "),
      @ApiResponse(responseCode = "404", description = "Libro no encontrado"),
      @ApiResponse(responseCode = "409", description = "El libro tiene copias disponibles")
  })
  public BookResponseDto deactivate(
      @Parameter(description = "Identificador del libro", example = "1") @PathVariable Long id) {
    return service.deactivate(id);
  }
}
