package com.aditi.resumeparser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aditi.resumeparser.model.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
