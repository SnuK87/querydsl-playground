package de.snuk.qdsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class DataRepositorySupport extends QuerydslRepositorySupport {

	private final JPAQueryFactory queryFactory;

	public DataRepositorySupport(JPAQueryFactory queryFactory) {
		super(DataE.class);
		this.queryFactory = queryFactory;
	}

	public List<DataE> search() {
		QDataE data = QDataE.dataE;
		QConfig config = QConfig.config;
		QProject project = QProject.project;

		return queryFactory.selectFrom(data) //
				.join(data.config, config) //
				.join(config.project, project)//
				.where(project.id.eq(1L)).fetch();
	}

}
