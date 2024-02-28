package org.example.academicperformance.services.impl;


import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.example.academicperformance.exceptions.NotFoundException;
import org.example.academicperformance.mappers.SubjectMapper;
import org.example.academicperformance.repositories.SubjectRepository;
import org.example.academicperformance.services.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Page<Subject> findSubjects(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return subjectRepository.findAll(pageable);
    }

    @Override
    public Subject findSubjectById(long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public Subject findSubjectByIdOrElseThrow(long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти предмет с id = " + id));
    }

    @Override
    public void deleteSubjectById(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Subject saveSubject(SubjectDTO subjectDTO) {
        Subject subject = SubjectMapper.INSTANCE.SubjectDTOToSubject(subjectDTO);
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> saveSubjects(List<SubjectDTO> subjectsDTO) {
        List<Subject> subjects = subjectsDTO
                .stream()
                .map(SubjectMapper.INSTANCE::SubjectDTOToSubject)
                .collect(Collectors.toList());
        return subjectRepository.saveAll(subjects);
    }

    @Override
    public Subject updateSubject(long id, SubjectDTO subjectDTO) {
        return SubjectMapper.INSTANCE
                .SubjectDTOToSubject(subjectDTO)
                .setId(findSubjectByIdOrElseThrow(id).getId());
    }

}
