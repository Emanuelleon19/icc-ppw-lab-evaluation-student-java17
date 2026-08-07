package ec.edu.ups.icc.libraryevaluation.users.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ec.edu.ups.icc.libraryevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.libraryevaluation.users.mappers.UserMapper;
import ec.edu.ups.icc.libraryevaluation.users.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDto> findActiveReaders(Integer minAge) {
        return repository.findByAgeGreaterThanEqualAndActiveTrueAndDeletedFalseOrderByFullNameAsc(minAge)
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
