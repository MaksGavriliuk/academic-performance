package org.example.academicperformance.services;


import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.springframework.data.domain.Page;

import java.util.List;


public interface AssessmentService {

    Page<Assessment> findAssessments(int pageNumber, int pageSize);

    Assessment findAssessmentById(long id);

    Assessment findAssessmentByIdOrElseThrow(long id);

    void deleteAssessmentById(long id);

    Assessment saveAssessment(AssessmentDTO assessmentDTO);

    List<Assessment> saveAssessments(List<AssessmentDTO> assessmentsDTO);

    Assessment updateAssessment(long id, AssessmentDTO AssessmentDTO);

}
