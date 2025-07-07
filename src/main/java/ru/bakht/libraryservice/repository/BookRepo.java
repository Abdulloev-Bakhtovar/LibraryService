package ru.bakht.libraryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bakht.libraryservice.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {
}
