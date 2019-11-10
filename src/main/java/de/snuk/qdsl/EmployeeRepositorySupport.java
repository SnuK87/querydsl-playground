package de.snuk.qdsl;

import java.util.List;

interface EmployeeRepositorySupport {

	List<Employee> findByOrganizationId(Long organizationId);
	
	List<Employee> findByDepartmentIdAndRoleName(Long departmentId, String roleName);
	
	List<EmployeeDto> findByOrganizationIdAndRoleName(Long organizationId, String roleName);
	
}
