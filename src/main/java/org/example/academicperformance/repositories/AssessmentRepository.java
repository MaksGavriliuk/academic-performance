package org.example.academicperformance.repositories;


import org.example.academicperformance.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

    List<Assessment> findAssessmentsByStudentId(long studentId);

    List<Assessment> findAssessmentsBySubjectId(long subjectId);

    List<Assessment> findAssessmentsByStudentIdAndSubjectId(long studentId, long subjectId);

}