package br.edu.ifbaiano.homines.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Object[]> find(String career, String classes, String stand, String post, String sector, String avaliation, String situation) {
		
		var jpqlOverview = new StringBuilder();
		var jpqlTAE = new StringBuilder();
		var jpqlDocente = new StringBuilder();
		
		
		var parameters = new HashMap<String, Object>();
		
		List<Object[]> dto = new ArrayList<>();
		Object[] total = new Object[3];
		
		jpqlOverview.append("select e.name, e.siape from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0");
		jpqlTAE.append("select count(e.career) from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'TAE'");
		jpqlDocente.append("select count(e.career) from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'DOCENTE'");

		
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
		
		//TODO Colocar o filtro das avaliações e situação
		
		if(avaliation != null) {
			
		}
		
		if(situation != null) {
			
		}
		
	TypedQuery<Object[]> queryTotal = manager.createQuery(jpqlOverview.toString(), Object[].class);
			parameters.forEach((key, value) -> queryTotal.setParameter(key, value));
	
	TypedQuery<Object[]> queryTAE = manager.createQuery(jpqlTAE.toString(), Object[].class);
			parameters.forEach((key, value) -> queryTAE.setParameter(key, value));
			
	TypedQuery<Object[]> queryDocente = manager.createQuery(jpqlDocente.toString(), Object[].class);
			parameters.forEach((key, value) -> queryDocente.setParameter(key, value));
			
			dto = queryTotal.getResultList();
			total[0] = queryTotal.getResultList().size();
			total[1] = queryTAE.getResultList();
			total[2] = queryDocente.getResultList();
		
			//TODO Organizar os objetos do Overview
			
			dto.add(total);
			
			return dto;
	}
}
