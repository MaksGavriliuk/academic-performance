package org.example.academicperformance.services.impl;


import lombok.AllArgsConstructor;
import org.example.academicperformance.annotations.CheckObjectExists;
import org.example.academicperformance.entities.Assessment;
import org.example.academicperformance.repositories.AssessmentRepository;
import org.example.academicperformance.services.AssessmentStudentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


@Service
@AllArgsConstructor
public class AssessmentStudentServiceImpl implements AssessmentStudentService {

    private final AssessmentRepository assessmentRepository;


    @Override
    @CheckObjectExists(repositoryClass = AssessmentRepository.class, idClass = Long.class)
    // проверять studentId с помощью FeignClient
    public List<Assessment> findAssessmentsByStudentId(long studentId) {
        return assessmentRepository.findAssessmentsByStudentId(studentId);
    }

    @Override
    public List<Assessment> findAssessmentsByStudentIdAndSubjectId(long studentId, long subjectId) {
        return assessmentRepository.findAssessmentsByStudentIdAndSubjectId(studentId, subjectId);
    }

    @Override
    public BigDecimal getStudentAverageScoreInSubject(long studentId, long subjectId) {
        List<Assessment> assessments = assessmentRepository.findAssessmentsByStudentIdAndSubjectId(studentId, subjectId);
        return getAverageScore(assessments);
    }

    @Override
    public BigDecimal getStudentAverageScore(long studentId) {
        List<Assessment> assessments = assessmentRepository.findAssessmentsByStudentId(studentId);
        return getAverageScore(assessments);
    }

    @Override
    public BigDecimal getAverageScoreInSubject(long subjectId) {
        List<Assessment> assessments = assessmentRepository.findAssessmentsBySubjectId(subjectId);
        return getAverageScore(assessments);
    }

    private BigDecimal getAverageScore(List<Assessment> assessments) {

        int count = assessments.size();
        int sum = assessments.stream()
                .mapToInt(Assessment::getScore)
                .sum();

        return (count == 0) ? BigDecimal.ZERO : BigDecimal.valueOf(sum)
                .divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);

    }

}
