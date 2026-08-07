package ec.edu.ups.icc.libraryevaluation.publishers.controllers;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ec.edu.ups.icc.libraryevaluation.publishers.dtos.PublisherResponseDto;
import ec.edu.ups.icc.libraryevaluation.publishers.services.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/publishers")
@Tag(name = "Publishers", description = "Consultas de editoriales")
public class PublisherController {
    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @GetMapping("/active")
    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @SecurityRequirement(name = "bearerAuth")
    @Operation(summary = "Listar editoriales activas por país")
    public List<PublisherResponseDto> findActiveByCountry(
            @Parameter(description = "País exacto, sin distinguir mayúsculas", example = "Ecuador") @RequestParam String country) {
        return service.findActiveByCountry(country);
    }
}
