package br.edu.ifbaiano.homines.domain.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;

import br.edu.ifbaiano.homines.api.controllers.ProbationaryStageController;
import br.edu.ifbaiano.homines.domain.model.Employee;
import br.edu.ifbaiano.homines.domain.model.ProbationaryStage;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(controllers = ProbationaryStageController.class)
public class ProbationaryStageServiceTest {

	
	@Autowired
	private ProbationaryStageRepository probationaryStageRepository;
	
	ProbationaryStage probationaryStage = new ProbationaryStage();
	Employee employee = new Employee();
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.probationaryStageRepository);
	}
	
	@Test
	public void shouldReturnSuccess_WhenPostProbationaryStage() {
		employee.setId(1L);
		probationaryStage.setEmployee(employee);
		
		
		
		RestAssuredMockMvc.
		given()
			.contentType("application/json")
			.body(this.probationaryStage)
		.when()
			.post("/employees/1/probationary-stage")
		.then()
			.statusCode(HttpStatus.CREATED.value());
	}
	
	
}
