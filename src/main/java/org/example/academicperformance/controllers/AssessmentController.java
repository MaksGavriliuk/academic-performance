package org.example.academicperformance.controllers;


import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.AssessmentDTO;
import org.example.academicperformance.entities.Assessment;
import org.example.academicperformance.services.AssessmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/assessments")
@AllArgsConstructor
public class AssessmentController {

    private final AssessmentService assessmentService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AssessmentDTO> getAssessments(Pageable pageable) {
        return assessmentService.findAssessments(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Assessment getAssessmentById(@PathVariable long id) {
        return assessmentService.findAssessmentById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssessmentDTO saveAssessment(@RequestBody AssessmentDTO assessmentDTO) {
        return assessmentService.saveAssessment(assessmentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AssessmentDTO updateAssessment(@PathVariable long id, @RequestBody AssessmentDTO assessmentDTO) {
        return assessmentService.updateAssessment(id, assessmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssessment(@PathVariable long id) {
        assessmentService.deleteAssessmentById(id);
    }

}