package ru.bakht.libraryservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bakht.libraryservice.dto.BookDto;
import ru.bakht.libraryservice.exception.AppException;
import ru.bakht.libraryservice.mapper.BookMapper;
import ru.bakht.libraryservice.repository.AuthorRepo;
import ru.bakht.libraryservice.repository.BookRepo;
import ru.bakht.libraryservice.service.BookService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final BookMapper bookMapper;

    @Override
    @Transactional(readOnly = true)
    public List<BookDto> getAll() {
        return bookRepo.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookDto getById(Long id) {
        var book = bookRepo.findById(id)
                .orElseThrow(() -> new AppException(
                        "Book not found with id: " + id, 
                        HttpStatus.NOT_FOUND
                ));
        
        return bookMapper.toDto(book);
    }

    @Override
    public BookDto create(BookDto bookDto) {
        var authorId = bookDto.getAuthor().getId();
        var author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AppException(
                        "Author not found with id: " + authorId,
                        HttpStatus.NOT_FOUND
                ));
        var book = bookMapper.toEntity(bookDto, author);

        book = bookRepo.save(book);

        return bookMapper.toDto(book);
    }

    @Override
    public BookDto update(Long id, BookDto bookDto) {
        var book = bookRepo.findById(id)
                .orElseThrow(() -> new AppException(
                        "Book not found with id: " + id, 
                        HttpStatus.NOT_FOUND
                ));
        var authorId = bookDto.getAuthor().getId();
        var author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AppException(
                        "Author not found with id: " + authorId,
                        HttpStatus.NOT_FOUND
                ));

        bookMapper.toEntity(book, bookDto, author);
        book = bookRepo.save(book);

        return bookMapper.toDto(book);
    }

    @Override
    public void delete(Long id) {
        if (!bookRepo.existsById(id)) {
            throw new AppException(
                    "Book not found with id: " + id,
                    HttpStatus.NOT_FOUND
            );
        }

        bookRepo.deleteById(id);
    }
}
