package ru.bakht.libraryservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bakht.libraryservice.dto.AuthorDto;
import ru.bakht.libraryservice.service.AuthorService;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AuthorDto> getAllAuthors(@RequestParam(defaultValue = "0") @Min(0) int page,
                                         @RequestParam(defaultValue = "10") @Min(1) int size) {
        return authorService.getAll(page, size);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getAuthorById(@PathVariable @Min(1) Long id) {
        return authorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto createAuthor(@RequestBody @Valid AuthorDto authorDTO) {
        return authorService.create(authorDTO);
    }
}
