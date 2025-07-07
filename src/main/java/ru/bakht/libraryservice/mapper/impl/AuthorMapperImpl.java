package ru.bakht.libraryservice.mapper.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bakht.libraryservice.dto.AuthorDto;
import ru.bakht.libraryservice.exception.AppException;
import ru.bakht.libraryservice.mapper.AuthorMapper;
import ru.bakht.libraryservice.model.Author;

@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toEntity(AuthorDto dto) {
        if (dto == null) {
            throw new AppException(
                    "Dto cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        return Author.builder()
                .name(dto.getName())
                .birthYear(dto.getBirthYear())
                .build();
    }

    @Override
    public AuthorDto toDto(Author entity) {
        if (entity == null) {
            throw new AppException(
                    "Entity cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        return AuthorDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .birthYear(entity.getBirthYear())
                .build();
    }
}
