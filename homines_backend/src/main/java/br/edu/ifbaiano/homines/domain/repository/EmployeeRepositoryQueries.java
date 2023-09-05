package br.edu.ifbaiano.homines.domain.repository;

import java.util.List;

public interface EmployeeRepositoryQueries {

	List<Object[]> find(String career, String classes, String stand, String post, String sector, String avaliation, String situation);

}