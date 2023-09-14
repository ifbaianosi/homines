package br.edu.ifbaiano.homines.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifbaiano.homines.api.DTO.overview.EmployeeDTO;

@Component
public class EmployeeAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	

	public EmployeeDTO toDTO() {
		
		return null;		
	}

}
