package ec.edu.ups.icc.libraryevaluation.users.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.ups.icc.libraryevaluation.users.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmailAndDeletedFalse(String email);

    List<UserEntity> findByAgeGreaterThanEqualAndActiveTrueAndDeletedFalseOrderByFullNameAsc(Integer minAge);
}