package ru.bakht.libraryservice.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import ru.bakht.libraryservice.model.BaseEntity;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorDto extends BaseEntity {
    @NotBlank(message = "Author name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    String name;

    @Min(value = 1900, message = "Birth year must be at least 1900")
    Integer birthYear;
}