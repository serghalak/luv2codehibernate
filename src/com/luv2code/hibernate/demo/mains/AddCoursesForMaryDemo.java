package com.luv2code.hibernate.demo.mains;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Student mary=session.get(Student.class,3);
			System.out.println(mary);
			System.out.println("Mary courses: " + mary.getCourses());
			Course course1 = new Course("Rubik's Cube - how to Speed Cube");
			Course course2 = new Course("Atari 2600 - Game Development");
			course1.addStudent(mary);
			course2.addStudent(mary);
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}

	}

}
