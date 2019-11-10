package de.snuk.qdsl;

import static de.snuk.qdsl.QDepartment.department;
import static de.snuk.qdsl.QEmployee.employee;
import static de.snuk.qdsl.QRole.role;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.core.group.GroupBy;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
class EmployeeRepositorySupportImpl extends QuerydslRepositorySupport implements EmployeeRepositorySupport {

	private final JPAQueryFactory queryFactory;

	public EmployeeRepositorySupportImpl(JPAQueryFactory queryFactory) {
		super(Employee.class);
		this.queryFactory = queryFactory;
	}

	@Override
	public List<Employee> findByOrganizationId(Long organizationId) {
		return queryFactory.select(employee).from(employee, department)
		.where(department.organization.id.eq(organizationId)
				.and(employee.department.eq(department)))
		.fetch();
	}
	
	@Override
	public List<Employee> findByDepartmentIdAndRoleName(Long departmentId, String roleName) {
		return queryFactory.select(employee).from(employee, department)
				.innerJoin(employee.roles, role)
				.where(department.id.eq(departmentId)
						.and(role.name.eq(roleName))
						.and(employee.roles.any().eq(role))
						.and(employee.department.eq(department)))
				.fetch();
	}
	
	@Override
	public List<EmployeeDto> findByOrganizationIdAndRoleName(Long organizationId, String roleName) {
		return new ArrayList<>(queryFactory.select(employee).from(employee, department)
		.innerJoin(employee.roles, role)
		.where(department.organization.id.eq(organizationId)
				.and(employee.department.eq(department))
				.and(role.name.eq(roleName))
				.and(employee.roles.any().eq(role)))
		.transform(GroupBy.groupBy(employee.id)
				.as(new QEmployeeDto(employee.id, employee.email, employee.name, department.id)))
		.values());
	}
}
