package org.example.academicperformance.controllers;


import lombok.AllArgsConstructor;
import org.example.academicperformance.entities.Assessment;
import org.example.academicperformance.services.AssessmentStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

import java.util.List;


@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class AssessmentStudentController {

    private final AssessmentStudentService assessmentStudentService;


    @GetMapping("/{studentId}/assessments")
    @ResponseStatus(HttpStatus.OK)
    public List<Assessment> getAssessmentsByStudentId(@PathVariable long studentId) {
        return assessmentStudentService.findAssessmentsByStudentId(studentId);
    }

    @GetMapping("/{studentId}/assessments/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Assessment> getAssessmentsByStudentIdAndSubjectId(
            @PathVariable long studentId,
            @PathVariable long subjectId
    ) {
        return assessmentStudentService.findAssessmentsByStudentIdAndSubjectId(studentId, subjectId);
    }

    @GetMapping("/{studentId}/average-score")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getStudentAverageScore(@PathVariable long studentId) {
        return assessmentStudentService.getStudentAverageScore(studentId);
    }

    @GetMapping("/{studentId}/average-score/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getStudentAverageScoreInSubject(
            @PathVariable long studentId,
            @PathVariable long subjectId
    ) {
        return assessmentStudentService.getStudentAverageScoreInSubject(studentId, subjectId);
    }

    @GetMapping("/average-score/{subjectId}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal getAverageScoreInSubject(@PathVariable long subjectId) {
        return assessmentStudentService.getAverageScoreInSubject(subjectId);
    }

}