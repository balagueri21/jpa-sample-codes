package com.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.test.model.College;
import com.test.model.Department;
import com.test.model.Professor;
import com.test.model.ProfessorDepartment;
import com.test.model.Role;

public class Test {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-example");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		College college = new College();
		college.setName("Stanford University");
		
		em.persist(college);
		
		Professor profJohn = new Professor();
		profJohn.setCollege(college);
		profJohn.setName("John");
		college.getProfessorList().add(profJohn);
		
		em.persist(profJohn);
		
		Professor profPeter = new Professor();
		profPeter.setCollege(college);
		profPeter.setName("Peter");
		college.getProfessorList().add(profPeter);
		
		em.persist(profPeter);
		
		Department compDept = new Department();
		compDept.setName("Computer Department");
		
		em.persist(compDept);
		
		Department financeDept = new Department();
		financeDept.setName("Finance Department");
		
		em.persist(financeDept);
		
		Department healthDept = new Department();
		healthDept.setName("Health Department");
		
		em.persist(healthDept);
		
		Role accountantRole = new Role();
		accountantRole.setName("Accountant");
		
		em.persist(accountantRole);
		
		Role doctorRole = new Role();
		doctorRole.setName("Doctor");
		
		em.persist(doctorRole);
		
		Role compAdminRole = new Role();
		compAdminRole.setName("Computer Administrator");
		
		em.persist(compAdminRole);
		
		Role compSupport = new Role();
		compSupport.setName("Computer Support Specialist");
		
		em.persist(compSupport);
		
		// John works as an accountant in Finance Department
		ProfessorDepartment johnInFinanceDept = new ProfessorDepartment();
		johnInFinanceDept.setDepartment(financeDept);
		johnInFinanceDept.setProfessor(profJohn);
		johnInFinanceDept.setRole(accountantRole);
		profJohn.getProfDepartmentList().add(johnInFinanceDept);
		financeDept.getProfDepartmentList().add(johnInFinanceDept);
		
		em.persist(johnInFinanceDept);
		
		// Peter works as a doctor in Health Department
		ProfessorDepartment peterInHealthDept = new ProfessorDepartment();
		peterInHealthDept.setDepartment(healthDept);
		peterInHealthDept.setProfessor(profPeter);
		peterInHealthDept.setRole(doctorRole);
		profPeter.getProfDepartmentList().add(peterInHealthDept);
		healthDept.getProfDepartmentList().add(peterInHealthDept);
		
		em.persist(peterInHealthDept);
		
		// Both John and Peter works in Computer Department but they are of different roles
		// John works as Computer Administrator
		// Peter works as Computer Support Specialist
		ProfessorDepartment johnInCompDept = new ProfessorDepartment();
		johnInCompDept.setDepartment(compDept);
		johnInCompDept.setProfessor(profJohn);
		johnInCompDept.setRole(compAdminRole);
		profJohn.getProfDepartmentList().add(johnInCompDept);
		compDept.getProfDepartmentList().add(johnInCompDept);
		
		em.persist(johnInCompDept);
		
		ProfessorDepartment peterInCompDept = new ProfessorDepartment();
		peterInCompDept.setDepartment(compDept);
		peterInCompDept.setProfessor(profPeter);
		peterInCompDept.setRole(compSupport);
		profPeter.getProfDepartmentList().add(peterInCompDept);
		compDept.getProfDepartmentList().add(peterInCompDept);
		
		em.persist(peterInCompDept);
		
		em.getTransaction().commit();
	}
}
