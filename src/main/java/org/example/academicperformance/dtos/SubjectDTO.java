package org.example.academicperformance.dtos;

import jakarta.validation.constraints.NotBlank;

public record SubjectDTO(
        @NotBlank String name
) {
}
