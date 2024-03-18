package org.example.academicperformance.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AssessmentDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) @NotNull Long studentId,
        @NotNull Long subjectId,
        @NotNull @Min(1) @Max(10) Integer score
) {
}