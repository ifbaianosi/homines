package br.edu.ifbaiano.homines.infrastructure.service.query;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.QueryDTO;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public QueryDTO find(String career, String classes, String stand, String post, String sector, String avaliation, String situation, Pageable pageable) {
		
		var jpqlOverview = new StringBuilder();
		var jpqlTAE = new StringBuilder();
		var jpqlDocente = new StringBuilder();
				
		var parameters = new HashMap<String, Object>();

		jpqlOverview.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 ");
		jpqlTAE.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'TAE'");
		jpqlDocente.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'DOCENTE'");

		
		if(career != null) {
			jpqlOverview.append("and e.career.career = :career ");
			jpqlTAE.append("and e.career.career = :career ");
			jpqlDocente.append("and e.career.career = :career ");
			
			parameters.put("career", career);
		}
		
		if(classes != null) {
			jpqlOverview.append("and e.classes.classes = :classes ");
			jpqlTAE.append("and e.classes.classes = :classes ");
			jpqlDocente.append("and e.classes.classes = :classes ");
			parameters.put("classes", classes);
		}
		
		if(stand != null) {
			jpqlOverview.append("and e.stand.stand = :stand ");
			jpqlTAE.append("and e.stand.stand = :stand ");
			jpqlDocente.append("and e.stand.stand = :stand ");
			parameters.put("stand", stand);
		}
		
		if(post != null) {
			jpqlOverview.append("and e.post.post = :post ");
			jpqlTAE.append("and e.post.post = :post ");
			jpqlDocente.append("and e.post.post = :post ");
			parameters.put("post", post);
		}
		
		if(sector != null) {
			jpqlOverview.append("and e.sector.sector = :sector ");
			jpqlTAE.append("and e.sector.sector = :sector ");
			jpqlDocente.append("and e.sector.sector = :sector ");
			parameters.put("sector", sector);
		}
		
		if(avaliation != null && situation != null) {
			
			if(avaliation.equals("1") && situation.equals("started")) {
				jpqlOverview.append("and pb.firstAvaliationDateBegin <= :today ");
				jpqlTAE.append("and pb.firstAvaliationDateBegin <= :today ");
				jpqlDocente.append("and pb.firstAvaliationDateBegin <= :today ");
				parameters.put("today", LocalDate.now());
			}else if(avaliation.equals("1") && situation.equals("finished")) {
				jpqlOverview.append("and pb.firstAvaliationDateEnd < :today ");
				jpqlTAE.append("and pb.firstAvaliationDateEnd < :today ");
				jpqlDocente.append("and pb.firstAvaliationDateEnd < :today ");
				parameters.put("today", LocalDate.now());
			}else if(avaliation.equals("2") && situation.equals("started")) {
				jpqlOverview.append("and pb.secondAvaliationDateBegin <= :today ");
				jpqlTAE.append("and pb.secondAvaliationDateBegin <= :today ");
				jpqlDocente.append("and pb.secondAvaliationDateBegin <= :today ");
				parameters.put("today", LocalDate.now());
			}else if(avaliation.equals("2") && situation.equals("finished")) {
				jpqlOverview.append("and pb.secondAvaliationDateEnd < :today ");
				jpqlTAE.append("and pb.secondAvaliationDateEnd < :today ");
				jpqlDocente.append("and pb.secondAvaliationDateEnd < :today ");
				parameters.put("today", LocalDate.now());
			}else if(avaliation.equals("3") && situation.equals("started")) {
				jpqlOverview.append("and pb.thirdAvaliationDateBegin <= :today ");
				jpqlTAE.append("and pb.thirdAvaliationDateBegin <= :today ");
				jpqlDocente.append("and pb.thirdAvaliationDateBegin <= :today ");
				parameters.put("today", LocalDate.now());
			}else if(avaliation.equals("3") && situation.equals("finished")) {
				jpqlOverview.append("and pb.thirdAvaliationDateEnd < :today ");
				jpqlTAE.append("and pb.thirdAvaliationDateEnd < :today ");
				jpqlDocente.append("and pb.thirdAvaliationDateEnd < :today ");
				parameters.put("today", LocalDate.now());
			}
			
		}

		
	TypedQuery<EmployeeQueryDTO> queryEmployee = manager.createQuery(jpqlOverview.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryEmployee.setParameter(key, value));
	
	TypedQuery<EmployeeQueryDTO> queryTAE = manager.createQuery(jpqlTAE.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryTAE.setParameter(key, value));
			
	TypedQuery<EmployeeQueryDTO> queryDocente = manager.createQuery(jpqlDocente.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryDocente.setParameter(key, value));
					
			QueryDTO queryDTO = new QueryDTO();
			//queryEmployee.setFirstResult(0);
			//queryEmployee.setMaxResults(1);
			
			queryDTO.setEmployeeQueryDTO(queryEmployee.getResultList());
			queryDTO.setTotal(queryEmployee.getResultList().size());
			queryDTO.setDocente(queryDocente.getResultList().size());
			queryDTO.setTae(queryTAE.getResultList().size());
//TODO Falta fazer a paginação pela TypedQuery 

			
			return queryDTO;
	}
}
