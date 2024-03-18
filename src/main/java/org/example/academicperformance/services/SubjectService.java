package org.example.academicperformance.services;

import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    Page<SubjectDTO> findSubjects(Pageable pageable);

    Subject findSubjectById(long id);

    void deleteSubjectById(long id);

    SubjectDTO saveSubject(SubjectDTO subjectDTO);

    List<SubjectDTO> saveSubjects(List<SubjectDTO> subjectsDTO);

    SubjectDTO updateSubject(long id, SubjectDTO subjectDTO);

}
