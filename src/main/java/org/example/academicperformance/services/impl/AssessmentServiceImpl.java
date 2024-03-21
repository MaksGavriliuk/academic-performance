package org.example.academicperformance.services.impl;


import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.example.academicperformance.exceptions.NotFoundException;
import org.example.academicperformance.mappers.AssessmentMapper;
import org.example.academicperformance.repositories.AssessmentRepository;
import org.example.academicperformance.services.AssessmentService;
import org.example.academicperformance.services.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {

    private final AssessmentRepository assessmentsRepository;
    private final AssessmentMapper assessmentMapper;
    private final SubjectService subjectService;


    @Override
    public Page<AssessmentDTO> findAssessments(Pageable pageable) {
        return assessmentsRepository.findAll(pageable)
                .map(assessmentMapper::toAssessmentDTO);
    }

    @Override
    public Assessment findAssessmentById(long id) {
        return assessmentsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти оценку с id = " + id));
    }

    @Override
    public void deleteAssessmentById(long id) {
        assessmentsRepository.deleteById(id);
    }

    @Override
    public AssessmentDTO saveAssessment(AssessmentDTO assessmentDTO) {
        subjectService.findSubjectById(assessmentDTO.subjectId());
        Assessment assessment = assessmentMapper.toAssessment(assessmentDTO);
        Assessment savedAssessment = assessmentsRepository.save(assessment);
        return assessmentMapper.toAssessmentDTO(savedAssessment);
    }

    @Override
    public AssessmentDTO updateAssessment(long id, AssessmentDTO assessmentDTO) {
        Assessment assessment = assessmentMapper
                .toAssessment(assessmentDTO)
                .setId(findAssessmentById(id).getId());
        Assessment updatedAssessment = assessmentsRepository.save(assessment);
        return assessmentMapper.toAssessmentDTO(updatedAssessment);
    }

 }