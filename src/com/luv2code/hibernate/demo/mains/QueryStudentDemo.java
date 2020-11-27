package com.luv2code.hibernate.demo.mains;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			List<Student>students = session
										.createQuery("from Student s where s.id=5")
										.getResultList();
			System.out.println(students);
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
	}

}
