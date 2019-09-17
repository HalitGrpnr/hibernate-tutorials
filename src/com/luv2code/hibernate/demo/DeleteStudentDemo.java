package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


public class DeleteStudentDemo {

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
			
			int studentId = 4;
			 
			// now get a new sesion and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting student with id: "+ studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("Get complete: "+ myStudent);
			 
			// delete the student
			session.delete(myStudent);
			
			// delete the student
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
	}

}












