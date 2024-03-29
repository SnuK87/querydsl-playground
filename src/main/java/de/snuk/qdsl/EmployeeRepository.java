package de.snuk.qdsl;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositorySupport {

}
