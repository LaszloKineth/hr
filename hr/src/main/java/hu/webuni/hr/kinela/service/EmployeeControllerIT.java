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

import hu.webuni.hr.kinela.mapper.EmployeeMapperMyImp;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

	private static final String EMPLOYEE_URI = "/api/employees";
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	EmployeeMapperMyImp mapper;
	
	@Test
	 void testAddEployeePOST() {
		 
		List<EmployeeDto> employeesBeforeTest = getAllEmployeesGETrequest(); 
		
		EmployeeDto newEmployee = mapper.employeeToEmployeeDto(new Employee(10, "Tenth Man", "TEST-ER", 130, LocalDateTime.now()));
		addEmployeeWithPOST(newEmployee);
		
		List<EmployeeDto> employeesAfterTest = getAllEmployeesGETrequest();
		
		assertThat(employeesAfterTest.contains(newEmployee));
			
	 }
	
	@Test
	void testModifyEmployeePUT() {
		
		EmployeeDto modifiedEmployee = mapper.employeeToEmployeeDto(new Employee(100, "Modi Fy", "TEST-ER", 130, LocalDateTime.now()));
		modifyEmployeePUTrequest(1, modifiedEmployee);
		
		assertThat(getEmployeeDTO(1).equals(modifiedEmployee));
	}

	private EmployeeDto getEmployeeDTO(int i) {
		
		EmployeeDto emp = webTestClient
			.get()
			.uri(EMPLOYEE_URI + "/" + i)
			.exchange()
			.expectStatus()
			.isOk()
			.expectBody(EmployeeDto.class)
			.returnResult()
			.getResponseBody();
			
		return emp;
	}

	private void modifyEmployeePUTrequest(int i, EmployeeDto modifiedEmployee) {
		webTestClient
			.put()
			.uri(EMPLOYEE_URI + "/" + i)
			.bodyValue(modifiedEmployee)
			.exchange()
			.expectStatus()
			.isOk();
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
