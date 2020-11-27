package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course( String title) {
		super();		
		this.title = title;		
	}

	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE
			, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id",referencedColumnName="id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="course_id",referencedColumnName="id")
	private List<Review> reviews;
	
	
	@ManyToMany/*(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE
			, CascadeType.DETACH, CascadeType.REFRESH})*/
	@JoinTable(name="course_student"
		,joinColumns= @JoinColumn(name="course_id",referencedColumnName="id")
		,inverseJoinColumns= @JoinColumn(name="student_id",referencedColumnName="id"))	
	private List<Student> students;
	
	public void addReview(Review tempReview) {
		if(reviews == null) {
			reviews=new ArrayList<>();
		}
		reviews.add(tempReview);
	}
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student student) {
		
		if(students==null) {
			students=new ArrayList();
		}		
		students.add(student);
	}
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	

}
