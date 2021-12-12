package edu.neu.csye6200.health;

import java.util.Date;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.student.Student;
import edu.neu.csye6200.student.StudentController;

public class VaccineRecord {

    private int recordId;
    private Vaccine vaccine;
    private Date recievedDate;
    private Person person;

    public VaccineRecord(int id, Vaccine vaccine, Date recivedDate, Person person) {
        this.recordId = id;
        this.vaccine = vaccine;
        this.recievedDate = recivedDate;
        this.person = person;
    }

    VaccineRecord(String csvString, StudentController studentController) {

        this.recordId = -1;
        this.vaccine = null;
        this.recievedDate = null;
        this.person = null;

        String[] data = csvString.split(",");

        try {
            this.recordId = Integer.parseInt(data[0]);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error while parsing record id");
        }
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

    public String toCSV() {
        return this.getRecordId() + "," + ((Student) this.getPerson()).getSId() + "," + this.getVaccine().getId() + "," + this.getRecievedDate();
    }

    @Override
    public String toString() {
        return ((Integer) this.getRecordId()).toString();
    }

}
