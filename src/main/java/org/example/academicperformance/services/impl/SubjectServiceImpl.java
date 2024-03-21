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


@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    @Override
    public Page<SubjectDTO> findSubjects(Pageable pageable) {
        return subjectRepository.findAll(pageable)
                .map(subjectMapper::toSubjectDTO);
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
        Subject savedSubject = subjectRepository.save(subjectMapper.toSubject(subjectDTO));
        return subjectMapper.toSubjectDTO(savedSubject);
    }

    @Override
    public SubjectDTO updateSubject(long id, SubjectDTO subjectDTO) {
        Subject subject = subjectMapper
                .toSubject(subjectDTO)
                .setId(findSubjectById(id).getId());
        Subject savedSubject = subjectRepository.save(subject);
        return subjectMapper.toSubjectDTO(savedSubject);
    }

}