package ec.edu.ups.icc.libraryevaluation.users.mappers;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import ec.edu.ups.icc.libraryevaluation.users.dtos.UserResponseDto;
import ec.edu.ups.icc.libraryevaluation.users.entities.UserEntity;

public final class UserMapper {
    private UserMapper() {
    }

    public static UserResponseDto toResponse(UserEntity entity) {
        return new UserResponseDto(
                entity.getId(),
                entity.getFullName(),
                entity.getEmail(),
                entity.getAge(),
                entity.isActive(),
                entity.getRoles().stream().map(role -> role.getName().name()).collect(Collectors.toSet()));
    }
}
