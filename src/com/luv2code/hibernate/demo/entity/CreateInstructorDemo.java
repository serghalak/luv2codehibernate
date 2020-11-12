package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()		
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			int id=5;
			session.beginTransaction();
			Instructor instructor=session.get(Instructor.class,id);
			
			System.out.println(instructor);
			System.out.println(instructor.getCourses());
			
			
			
			//List<Course>courses=new ArrayList<>();
//			Course course1=new Course("Air Guitar - The Ultimate Guide");
//			Course course2=new Course("The Pinball Masterclass");
//			instructor.add(course1);
//			instructor.add(course2);
			
//			courses.add(course1);
//			courses.add(course2);
//			instructor.setCourses(courses);
//			course1.setInstructor(instructor);
//			course2.setInstructor(instructor);
			
//			session.save(course1);
//			session.save(course2);
			//session.save(instructor);
			
//			Course course=session.get(Course.class,id);
//			Instructor instructor=course.getInstructor();
//			System.out.println(course);
//			System.out.println(instructor);
			session.getTransaction().commit();
		}finally {
			
			session.close();
			factory.close();
		}

	}

}
