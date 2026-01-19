package com.aditi.resumeparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditi.resumeparser.model.ResumeSkill;

@Repository
public interface ResumeSkillRepository extends JpaRepository<ResumeSkill, Long> {
    // This interface should be empty for now.
    // All the necessary methods like save(), findById(), etc., are inherited from JpaRepository.
    // The problematic method `findDistinctCategoriesByResumeId` has been removed.
}