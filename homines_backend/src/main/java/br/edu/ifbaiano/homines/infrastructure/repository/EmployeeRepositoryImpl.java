package br.edu.ifbaiano.homines.infrastructure.repository;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.QueryDTO;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public QueryDTO find(String career, String classes, String stand, String post, String sector, String avaliation, String situation) {
		
		var jpqlOverview = new StringBuilder();
		var jpqlTAE = new StringBuilder();
		var jpqlDocente = new StringBuilder();
			
		var parameters = new HashMap<String, Object>();

		jpqlOverview.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 ");
		jpqlTAE.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape) "
				+ "from ProbationaryStage pb join Employee e on pb.employee.id = e.id where 0 = 0 and e.career.career = 'TAE'");
		jpqlDocente.append("select NEW br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO ( e.name, e.siape) "
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
		
		//TODO Colocar o filtro das avaliações e situação
		
		if(avaliation != null) {
			
		}
		
		if(situation != null) {
			
		}
		
	TypedQuery<EmployeeQueryDTO> queryEmployee = manager.createQuery(jpqlOverview.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryEmployee.setParameter(key, value));
	
	TypedQuery<EmployeeQueryDTO> queryTAE = manager.createQuery(jpqlTAE.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryTAE.setParameter(key, value));
			
	TypedQuery<EmployeeQueryDTO> queryDocente = manager.createQuery(jpqlDocente.toString(), EmployeeQueryDTO.class);
			parameters.forEach((key, value) -> queryDocente.setParameter(key, value));
					
			QueryDTO queryDTO = new QueryDTO();
			
			queryDTO.setEmployeeQueryDTO(queryEmployee.getResultList());
			queryDTO.setTotal(queryEmployee.getResultList().size());
			queryDTO.setDocente(queryDocente.getResultList().size());
			queryDTO.setTae(queryTAE.getResultList().size());

			return queryDTO;
	}
}
