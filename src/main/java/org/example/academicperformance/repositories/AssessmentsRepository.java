package org.example.academicperformance.repositories;


import org.example.academicperformance.entities.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssessmentsRepository extends JpaRepository<Assessment, Long> {
}