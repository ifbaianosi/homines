package br.edu.ifbaiano.homines.infrastructure.service.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQueryDTO;
import br.edu.ifbaiano.homines.api.DTO.query.EmployeeQuerySituationDTO;
import br.edu.ifbaiano.homines.domain.repository.EmployeeRepositoryQueries;
import br.edu.ifbaiano.homines.domain.service.QueryService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class QueryPdf implements QueryService{
	
	@Autowired
	@Qualifier("employeeRepository")
	private EmployeeRepositoryQueries employeeRepositoryQueries;
	private List<EmployeeQuerySituationDTO> resultList = new ArrayList<>();

	@Override
	public byte[] query(String career, String classes, String stand, String post, String sector, String avaliation,
			String situation, Pageable pageable) {
		
		
		try {
		var inputStream = this.getClass().getResourceAsStream("/reports/Employee_Situation.jasper");
		
		var parameters = new HashMap<String, Object>();
		parameters.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		List<EmployeeQueryDTO> employeesDTO = employeeRepositoryQueries.find(career, classes, stand, post, sector, avaliation, situation, pageable).getContent();
		
		
		employeesDTO.forEach(e ->{
			
				EmployeeQuerySituationDTO employeeJasperReport = new EmployeeQuerySituationDTO();
			
				employeeJasperReport.setCareer(e.getCareer());
				employeeJasperReport.setName(e.getName());
				employeeJasperReport.setSiape(e.getSiape());
				employeeJasperReport.setSituation(e.getSituation().getDescription());
				resultList.add(employeeJasperReport);
		});
		
		
		
		//var employees = employeeRepositoryQueries.find(career, classes, stand, post, sector, avaliation, situation, pageable);		
		var dataSource = new JRBeanCollectionDataSource(resultList);
		
		var jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
			
		return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (Exception e) {
			throw new ReportException("Was not possible to generate the report.", e);
		}
	
	}

}
