package com.spring.restapi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.restapi.dto.InspectionDTO;
import com.spring.restapi.exception.InspectionNotFoundException;
import com.spring.restapi.exception.InvalidFileException;
import com.spring.restapi.mapper.InspectionMapper;
import com.spring.restapi.model.Inspection;
import com.spring.restapi.repository.InspectionRepository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InspectionService {
	@Value("${file.upload-dir}")
    private String uploadDir;

    @Autowired
    private InspectionRepository inspectionRepository;

    @Autowired
    private InspectionMapper inspectionMapper;

    // ─── CREATE INSPECTION WITH FILE UPLOAD ──────────────────────────────────

    public InspectionDTO createInspection(String siteName, String inspectorName,
                                          LocalDate inspectionDate, String remarks,
                                          MultipartFile sitePhoto, MultipartFile safetyReport) throws IOException {

        // Validate files
        validatePhoto(sitePhoto);
        validateReport(safetyReport);

        // Save entity first to get the generated ID
        Inspection inspection = new Inspection();
        inspection.setSiteName(siteName);
        inspection.setInspectorName(inspectorName);
        inspection.setInspectionDate(inspectionDate);
        inspection.setRemarks(remarks);

        // Temporarily save to get ID
        Inspection saved = inspectionRepository.save(inspection);

        // Build storage path: uploads/inspections/{id}/
        Path inspectionDir = Paths.get(uploadDir, "inspections", String.valueOf(saved.getId()));
        Files.createDirectories(inspectionDir);

        // Save photo file
        String photoFileName = sitePhoto.getOriginalFilename();
        Files.copy(sitePhoto.getInputStream(),
                inspectionDir.resolve(photoFileName),
                StandardCopyOption.REPLACE_EXISTING);

        // Save report file
        String reportFileName = safetyReport.getOriginalFilename();
        Files.copy(safetyReport.getInputStream(),
                inspectionDir.resolve(reportFileName),
                StandardCopyOption.REPLACE_EXISTING);

        // Update entity with file names (not bytes)
        saved.setPhotoFileName(photoFileName);
        saved.setReportFileName(reportFileName);
        inspectionRepository.save(saved);

        return inspectionMapper.toDto(saved);
    }
    
    public List<InspectionDTO> getAll(){
    	return inspectionRepository.findAll().stream().map(inspectionMapper::toDto).collect(Collectors.toList());
    	 
    }

    // ─── GET INSPECTION BY ID ─────────────────────────────────────────────────

    public InspectionDTO getInspectionById(Long id) {
        Inspection inspection = inspectionRepository.findById(id).orElseThrow(() -> new InspectionNotFoundException("Inspection not found with id: "+id));
        
        return inspectionMapper.toDto(inspection);
    }

    // ─── DOWNLOAD SITE PHOTO ──────────────────────────────────────────────────

    public Resource downloadPhoto(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException("Inspection not found with id: "+id));

        return loadFileAsResource(id, inspection.getPhotoFileName());
    }

    // ─── DOWNLOAD SAFETY REPORT ───────────────────────────────────────────────

    public Resource downloadReport(Long id) {
        Inspection inspection = inspectionRepository.findById(id)
                .orElseThrow(() -> new InspectionNotFoundException("Inspection not found with id: "+id));

        return loadFileAsResource(id, inspection.getReportFileName());
    }

    // ─── HELPER: Load file as Resource ───────────────────────────────────────

    private Resource loadFileAsResource(Long inspectionId, String fileName) {
        try {
            Path filePath = Paths.get(uploadDir, "inspections",
                    String.valueOf(inspectionId), fileName).normalize();

            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                throw new InvalidFileException("File not found: " + fileName);
            }
            return resource;

        } catch (MalformedURLException e) {
            throw new InvalidFileException("Could not read file: " + fileName);
        }
    }

    // ─── VALIDATION ──────────────────────────────────────────────────────────

    private void validatePhoto(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new InvalidFileException("Site photo is required");
        }

        String contentType = file.getContentType();
        if (!List.of("image/jpeg", "image/png").contains(contentType)) {
            throw new InvalidFileException("Site photo must be JPG or PNG. Received: " + contentType);
        }
    }

    private void validateReport(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new InvalidFileException("Safety report is required");
        }

        String contentType = file.getContentType();
        if (!"application/pdf".equals(contentType)) {
            throw new InvalidFileException("Safety report must be a PDF. Received: " + contentType);
        }
    }
}
