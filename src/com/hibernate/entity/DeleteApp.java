package com.hibernate.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteApp {
	public static void main(String[] args) {
		// now if we simply delete Instructor object as per the cascading rule it
		// will delete the Instructor_detail object too
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		int id = 1;
		try {
			session.beginTransaction();
			Instructor koushik = session.get(Instructor.class, id);
			session.delete(koushik);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
