package hu.webuni.hr.kinela.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import hu.webuni.hr.kinela.mapper.EmployeeMapperImp;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

	private static final String EMPLOYEE_URI = "/api/employees";
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	EmployeeMapperImp mapper;
	
	@Test
	 void testAddEployeePOST() {
		 
		List<EmployeeDto> employeesBeforeTest = getAllEmployeesGETrequest(); 
		
		EmployeeDto newEmployee = mapper.employeeToEmployeeDto(new Employee(10, "Tenth Man", "TEST-ER", 130, LocalDateTime.now()));
		addEmployeeWithPOST(newEmployee);
		
		List<EmployeeDto> employeesAfterTest = getAllEmployeesGETrequest();
		
		assertThat(employeesAfterTest.subList(0, employeesAfterTest.size())).containsExactlyElementsOf(employeesBeforeTest);
		
		assertThat(employeesAfterTest.get(employeesAfterTest.size()-1)).isEqualTo(newEmployee);
	 }

	private void addEmployeeWithPOST(EmployeeDto employee) {
		webTestClient
			.post()
			.uri(EMPLOYEE_URI)
			.bodyValue(employee)
			.exchange()
			.expectStatus()
			.isOk();
	}

	private List<EmployeeDto> getAllEmployeesGETrequest() {
		
		List<EmployeeDto> responseList = webTestClient
			.get()
			.uri(EMPLOYEE_URI)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBodyList(EmployeeDto.class)
			.returnResult()
			.getResponseBody();
		
		return responseList;
	}
}
