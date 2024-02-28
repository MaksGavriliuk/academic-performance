package org.example.academicperformance.services.impl;


import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.example.academicperformance.exceptions.NotFoundException;
import org.example.academicperformance.mappers.AssessmentMapper;
import org.example.academicperformance.repositories.AssessmentsRepository;
import org.example.academicperformance.services.AssessmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentsRepository assessmentsRepository;


    @Override
    public Page<Assessment> findAssessments(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return assessmentsRepository.findAll(pageable);
    }

    @Override
    public Assessment findAssessmentById(long id) {
        return assessmentsRepository.findById(id).orElse(null);
    }

    @Override
    public Assessment findAssessmentByIdOrElseThrow(long id) {
        return assessmentsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти оценку с id = " + id));
    }

    @Override
    public void deleteAssessmentById(long id) {
        assessmentsRepository.deleteById(id);
    }

    @Override
    public Assessment saveAssessment(AssessmentDTO assessmentDTO) {
        Assessment assessment = AssessmentMapper.INSTANCE.AssessmentDTOToAssessment(assessmentDTO);
        return assessmentsRepository.save(assessment);
    }

    @Override
    public List<Assessment> saveAssessments(List<AssessmentDTO> assessmentsDTO) {
        List<Assessment> assessments = assessmentsDTO
                .stream()
                .map(AssessmentMapper.INSTANCE::AssessmentDTOToAssessment)
                .collect(Collectors.toList());
        return assessmentsRepository.saveAll(assessments);
    }

    @Override
    public Assessment updateAssessment(long id, AssessmentDTO assessmentDTO) {
        return AssessmentMapper.INSTANCE
                .AssessmentDTOToAssessment(assessmentDTO)
                .setId(findAssessmentByIdOrElseThrow(id).getId());
    }

}
