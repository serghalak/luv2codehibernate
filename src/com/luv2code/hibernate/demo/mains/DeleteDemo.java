package com.luv2code.hibernate.demo.mains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
//		Instructor instructor=new Instructor("Chad","Darby","darby@luv2code.com");
//		InstructorDetail instructorDetail=new InstructorDetail(
//				"http://www.luv2code.com/youtube","Luv 2 code!!!");
		
//		Instructor instructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
//		InstructorDetail instructorDetail=new InstructorDetail(
//				"http://youtube","Guitar");
//		instructor.setInstructorDetail(instructorDetail);
//		instructorDetail.setInstructor(instructor);
		
		
		
		try {			
			session.beginTransaction();
			//session.save(instructor);
			Instructor instructor=session.get(Instructor.class,3);
			session.delete(instructor);
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
