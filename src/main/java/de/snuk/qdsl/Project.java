package de.snuk.qdsl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Project {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
}
