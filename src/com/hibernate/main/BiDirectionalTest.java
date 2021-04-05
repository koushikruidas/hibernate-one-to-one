package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class BiDirectionalTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Instructor.class)
						.addAnnotatedClass(InstructorDetails.class)
						.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Instructor springTeacher = new Instructor("Binayak","Ghosh","ghoshbinayak@gmail.com");
			InstructorDetails detSpringTeacher = new InstructorDetails("https://youtube.com/spring/classes", "Coding");
			springTeacher.setInstructorDetail(detSpringTeacher);
			session.beginTransaction();
			session.save(springTeacher);
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
