package yuldmrb.book.persistance.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record Book(

        @NotNull
        @Positive
        Long id,

        @NotBlank
        String title,
        @NotBlank
        String author,
        String description) {
}
