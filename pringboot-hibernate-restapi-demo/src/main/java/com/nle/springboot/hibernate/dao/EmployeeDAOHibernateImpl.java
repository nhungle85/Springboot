package com.nle.springboot.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nle.springboot.hibernate.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	//define file for Entity manager
	private EntityManager entityManager;
	
	//setup constructor injection - Automatic created by Spring boot
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	@Transactional //handles transaction management, so we don't have to manual start and commit transaction
	public List<Employee> findAll() {
		//1. Get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//2. Create query - using native Hibernate API
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		//3. Get result
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

}
