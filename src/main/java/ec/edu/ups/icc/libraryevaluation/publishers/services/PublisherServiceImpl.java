package ec.edu.ups.icc.libraryevaluation.publishers.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.ups.icc.libraryevaluation.publishers.dtos.PublisherResponseDto;
import ec.edu.ups.icc.libraryevaluation.publishers.mappers.PublisherMapper;
import ec.edu.ups.icc.libraryevaluation.publishers.repositories.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository repository;

    public PublisherServiceImpl(PublisherRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PublisherResponseDto> findActiveByCountry(String country) {
        return repository.findByCountryIgnoreCaseAndActiveTrueAndDeletedFalseOrderByNameAsc(country)
                .stream()
                .map(PublisherMapper::toResponse)
                .toList();
    }
}
