package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			// Create Instructor object and InstructorDetails object
			Instructor koushik = new Instructor("Koushik","ruidas","koushikruidas@gmail.com");
			InstructorDetails detKou = new InstructorDetails("https://www.youtub.com/koushik","Playing Table Tennis");
			
			// Associate the objects
			koushik.setInstructorDetail(detKou);
			
			session.beginTransaction();
			
			// Save the instructor
			session.save(koushik);
			session.getTransaction().commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
