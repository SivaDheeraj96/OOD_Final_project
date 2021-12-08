package edu.neu.csye6200.health;

import java.util.Date;

import edu.neu.csye6200.Person;

public class VaccineRecord {
	private int recordId;
	private Vaccine vaccine;
	private Date recievedDate;
	private Person person;
	
	public VaccineRecord(int id, Vaccine vaccine, Date recivedDate, Person person, int personType) {
		this.recordId = id;
		this.vaccine = vaccine;
		this.recievedDate = recivedDate;
		this.person = person;
	}
	
	public Vaccine getVaccine() {
		return vaccine;
	}
	
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	
	public Date getRecievedDate() {
		return recievedDate;
	}
	
	public void setRecievedDate(Date recievedDate) {
		this.recievedDate = recievedDate;
	}
	
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public int getRecordId() {
		return recordId;
	}
	
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	
	@Override
	public String toString() {
		return "";
	}


}
