package org.example.academicperformance.controllers;

import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.example.academicperformance.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SubjectDTO> getSubjects(Pageable pageable) {
        return subjectService.findSubjects(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Subject getSubjectById(@PathVariable Long id) {
        return subjectService.findSubjectById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDTO createSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.saveSubject(subjectDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SubjectDTO updateSubject(
            @PathVariable long id,
            @RequestBody SubjectDTO subjectDTO
    ) {
        return subjectService.updateSubject(id, subjectDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSubject(@PathVariable long id) {
        subjectService.deleteSubjectById(id);
    }

}