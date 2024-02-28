package org.example.academicperformance.services;

import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    Page<Subject> findSubjects(int pageNumber, int pageSize);

    Subject findSubjectById(long id);

    Subject findSubjectByIdOrElseThrow(long id);

    void deleteSubjectById(long id);

    Subject saveSubject(SubjectDTO subjectDTO);

    List<Subject> saveSubjects(List<SubjectDTO> subjects);

    Subject updateSubject(long id, SubjectDTO subjectDTO);

}
