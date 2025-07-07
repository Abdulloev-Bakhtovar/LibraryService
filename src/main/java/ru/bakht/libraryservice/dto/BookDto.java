package ru.bakht.libraryservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookDto extends BaseDto {

    @NotBlank(message = "Title is required")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    String title;

    @NotNull(message = "Author information is required")
    AuthorDto author;

    @Min(value = 0, message = "Year must be positive")
    int year;

    @Size(max = 50, message = "Genre cannot exceed 50 characters")
    String genre;
}
