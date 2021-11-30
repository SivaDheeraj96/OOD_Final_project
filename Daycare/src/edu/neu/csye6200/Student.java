package edu.neu.csye6200;

public class Student extends Person {

	private double gpa;
	private int SId;
	public Student(String name, String parentname, long phonenumber, String address,int age,double gpa, int sId) {
		super(name, parentname, phonenumber, address,age);
		this.gpa = gpa;
		SId = sId;
	}
	
	
	@Override 
	public String toString() { 
		return "Student [Age=" + getAge() + ", gpa= "+getGpa()+", SId= "+ getSId() +
	  "Name()=" + getName() + "Parentname()=" + getParentname() + "Phonenumber()="
	  + getPhonenumber() + "Address()=" + getAddress() + "]"; 
		}
	 
	

	public double getGpa() {
		return gpa;
	}
	

	/*
	 * @Override public String toString() { return "Student [getGpa()=" + getGpa() +
	 * ", getSId()=" + getSId() + ", getName()=" + getName() + ", getParentname()="
	 * + getParentname() + ", getPhonenumber()=" + getPhonenumber() +
	 * ", getAddress()=" + getAddress() + ", getAge()=" + getAge() + "]"; }
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getSId() {
		return SId;
	}
	public void setSId(int sId) {
		SId = sId;
	}
	
	
}