package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")// yazmasak da default olarak hibernate.cfg.xml arar  
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session 
		Session session = factory.getCurrentSession();
		
		
		try {
			// use the session object to save Java object
			
			
			// create a student object
			System.out.println("Creating new student object........");
			Student tempStudent = new Student("Mickey", "Mouse", "mickeye@luv2code.com"); 
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// MY NEW CODE
			
			// find out the student's id: primary key
			System.out.println("saved student. generated id: " + tempStudent.getId());
			
			// now get a new sesion and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+ tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("Get complete: "+ myStudent);
			
			// commit the transaction
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}













