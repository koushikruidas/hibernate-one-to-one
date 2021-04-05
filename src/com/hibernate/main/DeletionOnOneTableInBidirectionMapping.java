package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class DeletionOnOneTableInBidirectionMapping {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			InstructorDetails springTeacher = session.get(InstructorDetails.class, 6);
			
			// remove the associated object reference
			// break bi-directional link
			System.out.println("Instructor details: "+springTeacher.getInstructor().toString());
			springTeacher.getInstructor().setInstructorDetail(null);
			System.out.println("Instructor details after setting the value to null: "+springTeacher.getInstructor().toString());
			session.delete(springTeacher);
			session.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			factory.close();
		}
	}

}
