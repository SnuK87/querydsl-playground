package de.snuk.qdsl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataService {

	
	private final ConfigRepo configRepo;
	private final ProjectRepo projectRepo;
	private final DateERepo dataRepo;
	
	@Transactional
	public void init() {
		Project p = new Project();
		p.setName("Project A");
		p = projectRepo.save(p);
		
		Project p2 = new Project();
		p2.setName("Project B");
		p2 = projectRepo.save(p2);
		
		Config c = new Config();
		c.setName("Config A");
		c.setProject(p);
		c = configRepo.save(c);
		
		Config c2 = new Config();
		c2.setName("Config B");
		c2.setProject(p2);
		c2 = configRepo.save(c2);
		
		DataE d = new DataE();
		d.setConfig(c);
		d.setName("Data A");
		d =dataRepo.save(d);
		
		DataE d3 = new DataE();
		d3.setConfig(c);
		d3.setName("Data C");
		d3 =dataRepo.save(d3);
		
		
		DataE d2 = new DataE();
		d2.setConfig(c2);
		d2.setName("Data B");
		d2 =dataRepo.save(d2);
		
		System.out.println(p);
		System.out.println(c);
		System.out.println(d);
		
	}
	
	
	@Transactional
	public void test() {
		// all data from project x
		// from data where data.config = config AND config.project = x;
		
		
	}
}
