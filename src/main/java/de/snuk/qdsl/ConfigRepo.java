package de.snuk.qdsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ConfigRepo extends JpaRepository<Config, Long>, QuerydslPredicateExecutor<Config>{

}
