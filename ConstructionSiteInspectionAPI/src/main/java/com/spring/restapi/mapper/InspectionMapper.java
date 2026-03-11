package com.spring.restapi.mapper;

import org.springframework.stereotype.Component;

import com.spring.restapi.dto.InspectionDTO;
import com.spring.restapi.model.Inspection;

@Component
public class InspectionMapper {
	
	public InspectionDTO toDto(Inspection inspection) {
		
		InspectionDTO dto = new InspectionDTO();
		
		dto.setId(inspection.getId());
		dto.setSiteName(inspection.getSiteName());
		dto.setInspectorName(inspection.getInspectorName());
		dto.setInspectionDate(inspection.getInspectionDate());
		dto.setRemarks(inspection.getRemarks());
		dto.setPhotoFileName(inspection.getPhotoFileName());
		dto.setReportFileName(inspection.getReportFileName());
		
		return dto;
	}

}
