package br.edu.ifbaiano.homines.infrastructure.service.query;

import java.time.LocalDate;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.QueryCount;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;				
	
	HashMap<String, Object> parameters = new HashMap<String, Object>();
	
	@Override
	public Page<EmployeeQueryDTO> find(String career, String classes, String stand, String post, String sector, 
			String avaliation, String situation, Pageable pageable) {
		
		parameters.clear();

		var jpqlOverview = new StringBuilder();
		
		jpqlOverview.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 ");
		
		if(career != null) {			
			jpqlOverview.append(careerCondition(career));
		}
		
		if(classes != null) {
			jpqlOverview.append(classCondition(classes));
		}
		
		if(stand != null) {
			jpqlOverview.append(standCondition(stand));
		}
		
		if(post != null) {
			jpqlOverview.append(postCondition(post));
		}
		
		if(sector != null) {
			jpqlOverview.append(sectorCondition(sector));
		}
		
		if(avaliation != null && situation != null) {
			jpqlOverview.append(avaliationAndSituationCondition(avaliation, situation));
		}
			
			TypedQuery<EmployeeQueryDTO> queryEmployee = manager.createQuery(jpqlOverview.toString(), EmployeeQueryDTO.class);
					parameters.forEach((key, value) -> queryEmployee.setParameter(key, value));

			Page<EmployeeQueryDTO> page = new PageImpl<>(queryEmployee.getResultList());
			 
			 return page;
	}
	
	@Override
	public QueryCount filterCount(String career, String classes, String stand, String post, String sector,
			String avaliation, String situation) {
		
		parameters.clear();
		
		var jpqlTAE = new StringBuilder();
		var jpqlDocente = new StringBuilder();
		
		jpqlTAE.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
		+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'TAE' ");
		jpqlDocente.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape, e.career.career) "
		+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'DOCENTE' ");
		
		if(career != null) {			
			String condition = careerCondition(career);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		if(classes != null) {
			String condition = classCondition(classes);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		if(stand != null) {
			String condition = standCondition(stand);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		if(post != null) {
			String condition = postCondition(post);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		if(sector != null) {
			String condition = sectorCondition(sector);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		if(avaliation != null && situation != null) {
			String condition = avaliationAndSituationCondition(avaliation, situation);
			
			jpqlTAE.append(condition);
			jpqlDocente.append(condition);
		}
		
		
		TypedQuery<EmployeeQueryDTO> queryTAE = manager.createQuery(jpqlTAE.toString(), EmployeeQueryDTO.class);
				parameters.forEach((key, value) -> queryTAE.setParameter(key, value));
				
		TypedQuery<EmployeeQueryDTO> queryDocente = manager.createQuery(jpqlDocente.toString(), EmployeeQueryDTO.class);
		parameters.forEach((key, value) -> queryDocente.setParameter(key, value));
				
		QueryCount queryCount = new QueryCount();
		
		queryCount.setDocente(queryDocente.getResultList().size());
		queryCount.setTae(queryTAE.getResultList().size());
		queryCount.setTotal(queryCount.getTae()+queryCount.getDocente());
		
		return queryCount;
	}
	
	public String careerCondition(String career) {
		parameters.put("career", career);
		return "and e.career.career = :career ";
	}
	
	public String classCondition(String classes) {
		parameters.put("classes", classes);
		return "and e.classes.classes = :classes ";
	}
	
	public String standCondition(String stand) {
		parameters.put("stand", stand);
		return "and e.stand.stand = :stand ";
	}
	
	public String postCondition(String post) {
		parameters.put("post", post);
		return "and e.post.post = :post ";
	}
	
	public String sectorCondition(String sector) {
		parameters.put("sector", sector);
		return "and e.sector.sector = :sector ";
	}
	
	public String avaliationAndSituationCondition(String avaliation, String situation) {
	    LocalDate today = LocalDate.now();
	    var condition = new StringBuilder();

	    if ("1".equals(avaliation) || "2".equals(avaliation) || "3".equals(avaliation)) {
	        String dateField = switch (avaliation) {
	            case "1" -> "firstAvaliationDate";
	            case "2" -> "secondAvaliationDate";
	            case "3" -> "thirdAvaliationDate";
	            default -> throw new IllegalArgumentException("Invalid avaliation: " + avaliation);
	        };

	        if ("started".equals(situation)) {
	            condition.append("and pb.").append(dateField).append("Begin <= :today ");
	        } else if ("finished".equals(situation)) {
	            condition.append("and pb.").append(dateField).append("End < :today ");
	        }
	    }

	    parameters.put("today", today);
	    return condition.toString();
	}
}
