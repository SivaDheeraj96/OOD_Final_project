package edu.neu.csye6200.classRoom;

import edu.neu.csye6200.student.Student;
import edu.neu.csye6200.teacher.Teacher;

public class ClassRoom {

	private int id;
	private String name;
	private Course course;
	private Teacher[] teachers;
	private Student[] students;//need to change to student groups
	
	protected ClassRoom(String data) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Teacher[] getTeachers() {
		return teachers;
	}
	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}
	public Student[] getStudents() {
		return students;
	}
	public void setStudents(Student[] students) {
		this.students = students;
	}
	
	
}
