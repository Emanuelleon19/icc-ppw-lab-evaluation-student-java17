package ec.edu.ups.icc.libraryevaluation.publishers.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.libraryevaluation.publishers.entities.PublisherEntity;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
  List<PublisherEntity> findByCountryIgnoreCaseAndActiveTrueAndDeletedFalseOrderByNameAsc(String country);
}
