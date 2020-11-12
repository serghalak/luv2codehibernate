package com.luv2code.hibernate.demo.entity;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();	
		
		
		try {
		
			int id=5;
			session.beginTransaction();
			
			Query<Instructor>query=session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses  where i.id=:id");  
			query.setParameter("id",id);
			Instructor instructor = query.getSingleResult();
			//Instructor instructor = session.get(Instructor.class,id);
			System.out.println(""+instructor);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}

	}

}
