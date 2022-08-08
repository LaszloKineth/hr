package hu.webuni.hr.kinela;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.reactive.server.WebTestClient.ResponseSpec;

import hu.webuni.hr.kinela.mapper.EmployeeMapper;
import hu.webuni.hr.kinela.model.Employee;
import hu.webuni.hr.kinla.dto.EmployeeDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {

	private static final String EMPLOYEE_URI = "/api/employees";
	
	@Autowired
	WebTestClient webTestClient;
	
	@Autowired
	EmployeeMapper mapper;

	@Test
	 void goodRequestTestAddEployeePOST() {
		 
		List<EmployeeDto> employeesBeforeTest = getAllEmployeesGETrequest(); 
		
		EmployeeDto newEmployee = new EmployeeDto(10, "Test Name", "TEST-ER", 130, LocalDateTime.now());
		addGoodEmployeeWithPOST(newEmployee);
		
		List<EmployeeDto> employeesAfterTest = getAllEmployeesGETrequest();
		
		assertThat(employeesAfterTest.contains(newEmployee));
			
	 }

	@Test
	void goodRequestTestModifyEmployeePUT() {
		
		EmployeeDto modifiedEmployee = new EmployeeDto(100, "Test Name", "TEST-ER", 130, LocalDateTime.now());
		modifyGoodEmployeePUTrequest(1, modifiedEmployee);
		
		assertThat(getEmployeeDTO(1).equals(modifiedEmployee));
	}	
	
	@Test
	 void badRequestTestAddEployeePOST() {
		 
		List<EmployeeDto> employeesBeforeTest = getAllEmployeesGETrequest(); 
		
		EmployeeDto newEmployee = new EmployeeDto(10, "", "TEST-ER", 130, LocalDateTime.now());
		addBadEmployeeWithPOST(newEmployee);
		
		List<EmployeeDto> employeesAfterTest = getAllEmployeesGETrequest();
		
		assertThat(employeesAfterTest.contains(newEmployee));
			
	 }
	
	@Test
	void badTestModifyEmployeePUT() {
		
		EmployeeDto modifiedEmployee = new EmployeeDto(100, "", "TEST-ER", 130, LocalDateTime.now());
		modifyBadEmployeePUTrequest(1, modifiedEmployee);
		
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

	private void modifyBadEmployeePUTrequest(int i, EmployeeDto modifiedEmployee) {
		
		ResponseSpec badRequest = webTestClient
			.put()
			.uri(EMPLOYEE_URI + "/" + i)
			.bodyValue(modifiedEmployee)
			.exchange()
			.expectStatus()
			.isBadRequest();
	}

	private void modifyGoodEmployeePUTrequest(int i, EmployeeDto modifiedEmployee) {
		
		ResponseSpec badRequest = webTestClient
			.put()
			.uri(EMPLOYEE_URI + "/" + i)
			.bodyValue(modifiedEmployee)
			.exchange()
			.expectStatus()
			.isOk();
	}
	
	private void addGoodEmployeeWithPOST(EmployeeDto employee) {
		webTestClient
			.post()
			.uri(EMPLOYEE_URI)
			.bodyValue(employee)
			.exchange()
			.expectStatus()
			.isOk();
	}

	private void addBadEmployeeWithPOST(EmployeeDto employee) {
		webTestClient
			.post()
			.uri(EMPLOYEE_URI)
			.bodyValue(employee)
			.exchange()
			.expectStatus()
			.isBadRequest();
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
