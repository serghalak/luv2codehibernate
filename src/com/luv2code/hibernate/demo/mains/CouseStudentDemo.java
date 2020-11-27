package com.luv2code.hibernate.demo.mains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CouseStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student studentPaul=session.get(Student.class,1);
			
			Course course = session.get(Course.class,11);
			studentPaul.addCourse(course);
			course = session.get(Course.class,12);
			studentPaul.addCourse(course);
			session.save(studentPaul);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
	}

}
