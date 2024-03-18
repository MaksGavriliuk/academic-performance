package org.example.academicperformance.services.impl;


import lombok.AllArgsConstructor;
import org.example.academicperformance.dtos.SubjectDTO;
import org.example.academicperformance.entities.Subject;
import org.example.academicperformance.exceptions.NotFoundException;
import org.example.academicperformance.mappers.SubjectMapper;
import org.example.academicperformance.repositories.SubjectRepository;
import org.example.academicperformance.services.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    @Override
    public Page<SubjectDTO> findSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable)
                .map(SubjectMapper.INSTANCE::toSubjectDTO);
    }

    @Override
    public Subject findSubjectById(long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Не удалось найти предмет с id = " + id));
    }

    @Override
    public void deleteSubjectById(long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        Subject savedSubject = subjectRepository.save(SubjectMapper.INSTANCE.toSubject(subjectDTO));
        return SubjectMapper.INSTANCE.toSubjectDTO(savedSubject);
    }

    @Override
    public List<SubjectDTO> saveSubjects(List<SubjectDTO> subjectsDTO) {
        List<Subject> subjects = subjectsDTO
                .stream()
                .map(SubjectMapper.INSTANCE::toSubject)
                .toList();
        return subjectRepository.saveAll(subjects)
                .stream()
                .map(SubjectMapper.INSTANCE::toSubjectDTO)
                .toList();
    }

    @Override
    public SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) {
        Subject subject = SubjectMapper.INSTANCE
                .toSubject(subjectDTO)
                .setId(findSubjectById(id).getId());
        Subject savedSubject = subjectRepository.save(subject);
        return SubjectMapper.INSTANCE.toSubjectDTO(savedSubject);
    }

}