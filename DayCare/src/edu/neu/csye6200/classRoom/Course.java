package edu.neu.csye6200.classRoom;

public class Course {

	private int courseId;
	private String name;
	private String department;
	private int credit;
	
	protected Course(int courseId, String name, String department, int credit){
		this.courseId = courseId;
		this.name = name;
		this.department = department;
		this.credit = credit;
	}
	
	protected Course(String data) {
		this.courseId = -1;
		this.name = "";
		this.department = "";
		this.credit = 0;
		
		String[] vals = data.split(",");
		
		try {
			this.courseId = Integer.parseInt(vals[0]);
		}
		catch(Exception e) {
			System.err.println("error while parsing course id");
			e.printStackTrace();
		}
		
		this.name = vals[1];
		this.department = vals[2];
		try {
			this.credit = Integer.parseInt(vals[3]);
		}
		catch(Exception e) {
			System.err.println("error while parsing credit");
			e.printStackTrace();
		}
 	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String toString() {
		return this.getCourseId()+","+this.getName()+","+this.getDepartment()+","+this.getCredit();
	}
}
