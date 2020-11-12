package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();				
		
		Session session=factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			int id=1;
			Instructor instructor=session.get(Instructor.class,id);
			System.out.println("Instructor: " + instructor);
			
			System.out.println(instructor.getCourses());
			
			session.getTransaction().commit();
			session.close();
			
			System.out.println("Courses: " + instructor.getCourses());
			
			System.out.println("Done!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			factory.close();
		}
		
	}

}
