package ru.bakht.libraryservice.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import ru.bakht.libraryservice.dto.BookDto;
import ru.bakht.libraryservice.exception.AppException;
import ru.bakht.libraryservice.mapper.AuthorMapper;
import ru.bakht.libraryservice.mapper.BookMapper;
import ru.bakht.libraryservice.model.Author;
import ru.bakht.libraryservice.model.Book;

@Component
@RequiredArgsConstructor
public class BookMapperImpl implements BookMapper {

    private final AuthorMapper authorMapper;

    @Override
    public Book toEntity(BookDto dto, Author author) {
        if (dto == null) {
            throw new AppException(
                    "Dto cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        return Book.builder()
                .title(dto.getTitle())
                .year(dto.getYear())
                .genre(dto.getGenre())
                .author(author)
                .build();
    }

    @Override
    public void toEntity(Book book, BookDto dto, Author author) {
        if (dto == null) {
            throw new AppException(
                    "Dto cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        book.setTitle(dto.getTitle());
        book.setYear(dto.getYear());
        book.setGenre(dto.getGenre());
        book.setAuthor(author);
    }

    @Override
    public BookDto toDto(Book entity) {
        if (entity == null) {
            throw new AppException(
                    "Entity cannot be null",
                    HttpStatus.BAD_REQUEST
            );
        }

        return BookDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .author(authorMapper.toDto(entity.getAuthor()))
                .year(entity.getYear())
                .genre(entity.getGenre())
                .build();
    }
}
