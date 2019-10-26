package de.snuk.qdsl;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private Instant createdAt;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organization_id")
	private Organization organization;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<Employee> employees = new HashSet<>();

	public void addEmployee(Employee employee) {
		employees.add(employee);
		employee.setDepartment(this);
	}

	public void removeEmployeer(Employee employee) {
		employees.remove(employee);
		employee.setDepartment(null);
	}

}
