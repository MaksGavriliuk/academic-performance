package org.example.academicperformance.mappers;


import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.mapstruct.Mapper;


@Mapper
public interface SubjectMapper {

    SubjectDTO toSubjectDTO(Subject subject);

    Subject toSubject(SubjectDTO subjectDTO);

}