package ru.bakht.libraryservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.bakht.libraryservice.dto.BookDto;
import ru.bakht.libraryservice.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable @Min(1) Long id) {
        return bookService.getById(id);
    }

    @PostMapping
    public BookDto createBook(@RequestBody @Valid BookDto bookDTO) {
        return bookService.create(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable @Min(1) Long id, @RequestBody @Valid BookDto bookDTO) {
        return bookService.update(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable @Min(1) Long id) {
        bookService.delete(id);
    }
}
