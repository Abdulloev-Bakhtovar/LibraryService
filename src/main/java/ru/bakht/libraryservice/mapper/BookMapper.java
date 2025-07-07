package ru.bakht.libraryservice.mapper;

import ru.bakht.libraryservice.dto.BookDto;
import ru.bakht.libraryservice.model.Author;
import ru.bakht.libraryservice.model.Book;

public interface BookMapper {

    Book toEntity(BookDto bookDto, Author author);

    void toEntity(Book book, BookDto bookDto, Author author);

    BookDto toDto(Book entity);

}
