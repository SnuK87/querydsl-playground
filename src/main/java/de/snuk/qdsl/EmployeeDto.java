package de.snuk.qdsl;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;

@Data
public class EmployeeDto {
	private Long id;
	private String email;
	private String name;
	private Long departmentId;
	
	@QueryProjection
	public EmployeeDto(Long id, String email, String name, Long departmentId) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.departmentId = departmentId;
	}
}
