package br.edu.ifbaiano.homines.domain.repository;

import br.edu.ifbaiano.homines.api.DTO.query.QueryDTO;

public interface EmployeeRepositoryQueries {

	QueryDTO find(String career, String classes, String stand, String post, String sector, String avaliation, String situation);

}