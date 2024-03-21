package org.example.academicperformance.services;


import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface AssessmentService {

    Page<AssessmentDTO> findAssessments(Pageable pageable);

    Assessment findAssessmentById(long id);

    void deleteAssessmentById(long id);

    AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO);

    AssessmentDTO updateAssessment(long id, AssessmentDTO AssessmentDTO);

}