package edu.neu.csye6200;

public class Teacher extends Person {

	private int salary;
	private int TId;
	public Teacher(String name, String parentname, long phonenumber, String address,int age, int salary, int tId) {
		super(name, parentname, phonenumber, address, age);
		this.salary = salary;
		TId = tId;
	}

	@Override
	public String toString() {
		return "Teacher [salary=" + salary + ", TId=" + TId + ", getSalary()=" + getSalary() + ", getTId()=" + getTId()
				+ ", getName()=" + getName() + ", getParentname()=" + getParentname() + ", getPhonenumber()="
				+ getPhonenumber() + ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getTId() {
		return TId;
	}
	public void setTId(int tId) {
		TId = tId;
	}

}
