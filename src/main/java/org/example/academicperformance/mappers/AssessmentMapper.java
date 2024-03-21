package org.example.academicperformance.mappers;


import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface AssessmentMapper {

    @Mapping(source = "subject.id", target = "subjectId")
    AssessmentDTO toAssessmentDTO(Assessment assessment);

    @Mapping(source = "subjectId", target = "subject.id")
    Assessment toAssessment(AssessmentDTO assessmentDTO);

}