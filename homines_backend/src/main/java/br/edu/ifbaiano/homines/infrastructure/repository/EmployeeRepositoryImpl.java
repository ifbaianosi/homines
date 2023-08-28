package br.edu.ifbaiano.homines.infrastructure.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.domain.model.Career;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;
import br.edu.ifbaiano.homines.domain.repository.ProbationaryStageRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private ProbationaryStageRepository probationaryStageRepository;

	@Override
	public List<Object[]> find(Career career, String classes, String stand, String post, String sector, String avaliation, String situation) {
		
		var jpql = new StringBuilder();
		
		
		var parameters = new HashMap<String, Object>();
		
		List<Long> probationayStages = new ArrayList<>();
		
		probationayStages = probationaryStageRepository.onlyEmployeeId();
		//jpql.append("from Employee e where 0 = 0 and e.id in (:probationayStages)");
		
		probationayStages.stream().forEach(item -> System.out.println(item));

		
		if(career != null) {
			jpql.append("and e.career = :career ");
			parameters.put("career", career);
		}
		
		if(classes != null) {
			jpql.append("and e.classes = :classes ");
			parameters.put("classes", classes);
		}
		
		if(stand != null) {
			jpql.append("and e.stand = :stand ");
			parameters.put("stand", stand);
		}
		
		if(post != null) {
			jpql.append("and e.post = :post ");
			parameters.put("post", post);
		}
		
		if(sector != null) {
			jpql.append("and e.sector = :sector ");
			parameters.put("sector", sector);
		}
		
	TypedQuery<Object[]> query = manager.createQuery(jpql.toString(), Object[].class);
			parameters.forEach((key, value) -> query.setParameter(key, value));
			
			return query.getResultList();		
	}
}
