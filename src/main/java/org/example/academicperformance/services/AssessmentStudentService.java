package org.example.academicperformance.services;

import org.example.academicperformance.entities.Assessment;

import java.math.BigDecimal;
import java.util.List;


public interface AssessmentStudentService {

    List<Assessment> findAssessmentsByStudentId(long studentId);

    List<Assessment> findAssessmentsByStudentIdAndSubjectId(long studentId, long subjectId);

    BigDecimal getStudentAverageScoreInSubject(long studentId, long subjectId);

    BigDecimal getStudentAverageScore(long studentId);

    BigDecimal getAverageScoreInSubject(long subjectId);

}
