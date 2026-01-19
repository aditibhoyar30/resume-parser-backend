package com.aditi.resumeparser.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "certification")
@Data
@NoArgsConstructor
public class Certification {
    public void setResume(Resume resume) {
    this.resume = resume;
}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certification_name", columnDefinition = "TEXT")
    private String certificationName;

    @Column(name = "issuing_organization")
    private String issuingOrganization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id")
    @ToString.Exclude
    private Resume resume;
}