INSERT INTO organization (id, name) VALUES (1, 'ExampleOrganization');
INSERT INTO organization (id, name) VALUES (2, 'ExampleOrganization2');

INSERT INTO department (id, name, created_at, organization_id) VALUES (10, 'Department1', now(), 1), 
																	  (11, 'Department2', now(), 1), 
																	  (12, 'Department3', now(), 2);
																	  
INSERT INTO employee (id, email, name, department_id) VALUES (100, 'email1@example.de', 'Employee1', 10),	
															 (101, 'email2@example.de', 'Employee2', 10),
															 (102, 'email3@example.de', 'Employee3', 11),
															 (103, 'email4@example.de', 'Employee4', 11),
															 (104, 'email5@example.de', 'Employee5', 11),																  
															 (105, 'email6@example.de', 'Employee6', 12),																  
															 (106, 'email7@example.de', 'Employee7', 12),																  
															 (107, 'email8@example.de', 'Employee8', 12),																  
															 (108, 'email9@example.de', 'Employee9', 12);														  

INSERT INTO role (id, name) VALUES (1000, 'ADMIN'),
								   (1001, 'SUPERRVISOR'),
								   (1002, 'USER');
								   
INSERT INTO employee_has_role (employee_id, role_id) VALUES (100, 1000),
															(101, 1001),
															(102, 1000),								 							
															(103, 1001),								 							
															(104, 1002),								 							
															(105, 1000),								 							
															(106, 1001),								 							
															(107, 1002),								 							
															(108, 1002);							 							