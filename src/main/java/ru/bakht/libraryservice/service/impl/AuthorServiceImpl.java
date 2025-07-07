package ru.bakht.libraryservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bakht.libraryservice.dto.AuthorDto;
import ru.bakht.libraryservice.exception.AppException;
import ru.bakht.libraryservice.mapper.AuthorMapper;
import ru.bakht.libraryservice.repository.AuthorRepo;
import ru.bakht.libraryservice.service.AuthorService;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final AuthorMapper authorMapper;

    @Transactional(readOnly = true)
    public Page<AuthorDto> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return authorRepo.findAll(pageable)
                .map(authorMapper::toDto);
    }

    @Transactional(readOnly = true)
    public AuthorDto getById(Long id) {
        var author = authorRepo.findById(id)
                .orElseThrow(() -> new AppException(
                        "Author not found with id: " + id,
                        HttpStatus.NOT_FOUND
                ));

        return authorMapper.toDto(author);
    }

    public AuthorDto create(AuthorDto authorDTO) {
        var author = authorMapper.toEntity(authorDTO);
        author = authorRepo.save(author);

        return authorMapper.toDto(author);
    }
}

