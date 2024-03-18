package org.example.academicperformance.mappers;


import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AssessmentMapper {

    AssessmentMapper INSTANCE = Mappers.getMapper(AssessmentMapper.class);

    AssessmentDTO toAssessmentDTO(Assessment assessment);

    Assessment toAssessment(AssessmentDTO assessmentDTO);

}