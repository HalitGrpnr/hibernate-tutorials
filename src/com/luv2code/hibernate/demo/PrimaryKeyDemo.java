package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			
			
			// create 3 student object
			System.out.println("Creating 3 students object........");
			Student tempStudent1 = new Student("Paul", "Wall", "paul@luv2code.com");
			Student tempStudent2 = new Student("Halit", "Gürpınar", "halit@luv2code.com");
			Student tempStudent3 = new Student("Nicholas", "Doe", "nicholas@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
