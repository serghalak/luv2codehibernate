package com.luv2code.hibernate.demo.mains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		try {
			
			int id=12;
			session.beginTransaction();
			Course course = session.get(Course.class,id);
			System.out.println(course);
			System.out.println(course.getReviews());
			session.getTransaction().commit();
			System.out.println("Done!");
		}finally {
			session.close();
			factory.close();
		}
	}

}
