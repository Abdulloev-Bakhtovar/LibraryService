package ru.bakht.libraryservice.service;

import ru.bakht.libraryservice.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getById(Long id);

    BookDto create(BookDto bookDto);

    BookDto update(Long id, BookDto bookDto);

    void delete(Long id);
}
