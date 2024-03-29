package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// yazmasak da default olarak hibernate.cfg.xml arar  
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		
		
		try { 
			
			// start a transaction
			session.beginTransaction(); 
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").list();
			
			displayStudents(theStudents);
			
			// query students: lastName='Mouse'
			theStudents = session.createQuery("from Student s where s.lastName='Mouse'").list();
			
			System.out.println("\nStudents who have last name of Mouse!");
			displayStudents(theStudents);
			
			
			// query students: lastName='Mouse' or FirstName='Halit'
			theStudents = session.createQuery("from Student s where s.lastName='Mouse' OR s.firstName='Halit'").list();

			System.out.println("\nStudents who have last name of Mouse  or FirstName='Halit'!");
			displayStudents(theStudents);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		// display the students
		for(Student s : theStudents)
			System.out.println(s);
	}

}













