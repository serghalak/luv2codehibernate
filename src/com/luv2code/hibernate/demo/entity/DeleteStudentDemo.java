package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		int id=5;
		
		try {
			session.beginTransaction();
			Student deleteStudent=session.get(Student.class, id);
			session.delete(deleteStudent);
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}
	}

}
