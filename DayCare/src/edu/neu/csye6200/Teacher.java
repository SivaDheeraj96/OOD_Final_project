package edu.neu.csye6200;

public class Teacher extends Person {

	private int salary;
	private int tId;
	
	public Teacher(String name, String parentname, long phonenumber, String address,int age, int salary, int tId) {
		super(name, parentname, phonenumber, address, age);
		this.salary = salary;
		this.tId = tId;
	}

	public Teacher(String csvString) {
		super();
		String[] vals = csvString.split(",");
		this.name = "";
		this.parentName = "";
		this.phoneNumber = -1;
		this.address = "";
		this.age=-1;
		
		this.name = vals[0];
		
		this.parentName = vals[1];
		try {
			this.phoneNumber = Long.parseLong(vals[2]);
		}
		catch(Exception e) {
			System.err.println("Error while parsing phone number"+vals[2]);	
		}
		this.address = vals[3];
		
		try {
			this.age = Integer.parseInt(vals[4]);
		}
		catch(Exception e) {
			System.err.println("Error while parsing age"+vals[4]);	
		}
		try {
			this.salary = Integer.parseInt(vals[5]);
		}
		catch(Exception e) {
			System.err.println("Error while parsing salary"+vals[5]);	
		}
		try {
			this.tId = Integer.parseInt(vals[6]);
		}
		catch(Exception e) {
			System.err.println("Error while parsing teacher id"+vals[6]);	
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+","+this.getSalary()+","+this.getTId();
	}
	

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getTId() {
		return this.tId;
	}
	public void setTId(int tId) {
		this.tId = tId;
	}

}
