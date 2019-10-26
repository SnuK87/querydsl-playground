package de.snuk.qdsl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Organization {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = false)
	private Set<Department> departments = new HashSet<>();

	public void addDepartment(Department department) {
		departments.add(department);
		department.setOrganization(this);
	}

	public void removeUser(Department department) {
		departments.remove(department);
		department.setOrganization(null);
	}

}
