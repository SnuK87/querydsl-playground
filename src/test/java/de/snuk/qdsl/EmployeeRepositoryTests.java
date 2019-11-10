package de.snuk.qdsl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import({ EmployeeRepositorySupportImpl.class, QueryDslConfiguration.class })
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository repo;
	
	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void findByOrganization() throws Exception {
		List<Employee> actual = repo.findByOrganizationId(2L);
		
		assertThat(actual.size()).isEqualTo(4);
	}
	
	@Test
	public void findByDepartmentAndRole() throws Exception {
		List<Employee> actual = repo.findByDepartmentIdAndRoleName(12L, "USER");
		
		assertThat(actual.size()).isEqualTo(2);
	}
	
	@Test
	public void findByOrganizationIdAndRoleName() throws Exception {
		EmployeeDto expectedAdmin = new EmployeeDto(100L, "email1@example.de", "Employee1", 10L);
		
		List<EmployeeDto> actual = repo.findByOrganizationIdAndRoleName(1L, "ADMIN");
		
		assertThat(actual.size()).isEqualTo(2);
		assertThat(actual).contains(expectedAdmin);
	}
}
