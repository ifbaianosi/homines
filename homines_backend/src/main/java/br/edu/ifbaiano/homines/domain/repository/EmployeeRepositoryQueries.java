package br.edu.ifbaiano.homines.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.QueryCount;

public interface EmployeeRepositoryQueries {

	Page<EmployeeQueryDTO> find(String career, String classes, String stand, String post, String sector, String avaliation, String situation, Pageable pageable);
	
	QueryCount filterCount(String career, String classes, String stand, String post, String sector, String avaliation, String situation);

}