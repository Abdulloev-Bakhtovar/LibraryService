package ru.bakht.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bakht.libraryservice.model.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
}
