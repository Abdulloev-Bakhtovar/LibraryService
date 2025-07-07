package ru.bakht.libraryservice.service;

import org.springframework.data.domain.Page;
import ru.bakht.libraryservice.dto.AuthorDto;

public interface AuthorService {

    Page<AuthorDto> getAll(int page, int size);

    AuthorDto create(AuthorDto authorDto);

    AuthorDto getById(Long id);
}
