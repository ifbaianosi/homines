package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

import br.edu.ifbaiano.homines.domain.model.Career;

public interface EmployeeRepositoryQueries {

	List<Object[]> find(Career career, String classes, String stand, String post, String sector, String avaliation, String situation);

}