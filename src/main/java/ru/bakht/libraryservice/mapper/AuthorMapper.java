package ru.bakht.libraryservice.mapper;

import ru.bakht.libraryservice.dto.AuthorDto;
import ru.bakht.libraryservice.model.Author;

public interface AuthorMapper {

    Author toEntity(AuthorDto dto);

    AuthorDto toDto(Author entity);
}
