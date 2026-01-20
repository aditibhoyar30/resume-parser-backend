package com.aditi.resumeparser.service;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aditi.resumeparser.model.Resume;
import com.aditi.resumeparser.repository.ResumeRepository;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final NLPService nlpService;
    private final Tika tika;

    // The constructor now correctly injects all required services (ResumeRepository and NLPService).
    public ResumeService(ResumeRepository resumeRepository, NLPService nlpService) {
        this.resumeRepository = resumeRepository;
        this.nlpService = nlpService;
        this.tika = new Tika(); // Initialize Tika here
    }

    /**
     * Processes an uploaded resume file by extracting its text, parsing it for structured data,
     * and saving it to the database.
     *
     * @param file The uploaded MultipartFile.
     * @return The saved Resume entity with a generated ID.
     * @throws IOException   if there is an error reading the file.
     * @throws TikaException if there is an error parsing the file content.
     */
    public Resume processAndSaveResume(MultipartFile file) throws IOException, TikaException {
        // Step 1: Extract raw text content from the file using Apache Tika.
        String rawText = tika.parseToString(file.getInputStream());

        // Step 2: Pass the raw text to the NLPService to get a fully parsed and structured Resume object.
        Resume parsedResume = nlpService.parseResumeText(rawText);

        // Step 3: Set metadata that wasn't available during parsing (like the original filename).
        parsedResume.setOriginalFileName(file.getOriginalFilename());

        // Step 4: Save the complete, structured Resume object to the database via the repository.
        return resumeRepository.save(parsedResume);
    }
    
    //private final ResumeRepository resumeRepository;

    // TEMP TEST METHOD (we will remove later)
    // public Resume createTestResume() {
    //     Resume resume = new Resume();
    //     resume.setOriginalFileName("service_test_resume.pdf");
    //     resume.setFullName("Aditi Bhoyar");
    //     resume.setEmail("aditi@test.com");
    //     resume.setPhoneNumber("8888888888");
    //     resume.setSummary("Resume saved from service layer");
    //     resume.setCreatedAt(LocalDateTime.now());

    //     return resumeRepository.save(resume);
    // }
}