package de.snuk.qdsl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootApplication
public class QuerydslPlaygroundApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(QuerydslPlaygroundApplication.class, args);
	}

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
	
	@Autowired
	private DataService service;
	
	@Autowired
	private DataRepositorySupport sup;
	
	@Override
	public void run(String... args) throws Exception {
		service.init();
		service.test();
		
		List<DataE> search = sup.search();
		System.out.println(search);
	}

}
