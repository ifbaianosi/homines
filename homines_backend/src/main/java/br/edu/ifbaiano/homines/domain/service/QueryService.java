package br.edu.ifbaiano.homines.domain.service;

import org.springframework.data.domain.Pageable;

public interface QueryService {

	byte[] query(String career, String classes, String stand, String post, String sector, String avaliation, String situation, Pageable pageable);
}
