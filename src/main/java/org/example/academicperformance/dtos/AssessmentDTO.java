package org.example.academicperformance.dtos;

public record AssessmentDTO(
        Long studentId,
        Long subjectId,
        Integer score
) {
}