package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		Session session=factory.getCurrentSession();
		int id=5;
		try {			
			session.beginTransaction();
			List<Student>students=session.createQuery("from Student where id="+id).getResultList();
			students.get(0).setFirstName("Serg");
			
			session.createQuery("update Student s set s.email='serghalak@gmail.com' where id="+id).executeUpdate();
			 
			
			session.getTransaction().commit();
		}finally {
			factory.close();
		}
		

	}

}
