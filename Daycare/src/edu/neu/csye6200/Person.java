package edu.neu.csye6200;

public class Person {

	private String name;
	private String parentname;
	private long phonenumber;
	private String address;
	private int age;
	public Person(String name, String parentname, long phonenumber, String address, int age) {
		super();
		this.name = name;
		this.parentname = parentname;
		this.phonenumber = phonenumber;
		this.address = address;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentname() {
		return parentname;
	}
	public void setParentname(String parentname) {
		this.parentname = parentname;
	}
	public long getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
	