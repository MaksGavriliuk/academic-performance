package org.example.academicperformance.mappers;


import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    SubjectDTO toSubjectDTO(Subject subject);

    Subject toSubject(SubjectDTO subjectDTO);

}
