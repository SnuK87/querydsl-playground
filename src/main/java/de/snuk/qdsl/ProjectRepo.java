package de.snuk.qdsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ProjectRepo extends JpaRepository<Project, Long>, QuerydslPredicateExecutor<Project>{

}
