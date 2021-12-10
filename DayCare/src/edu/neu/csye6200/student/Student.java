package edu.neu.csye6200.student;

import edu.neu.csye6200.Person;

public class Student extends Person {

    private double gpa;
    private int sid;

    public Student(String name, String parentName, long phoneNumber, String address, int age, double gpa, int sid) {
        super(name, parentName, phoneNumber, address, age);
        this.gpa = gpa;
        this.sid = sid;
    }

    public Student(String csvString) {
        super();
        String[] vals = csvString.split(",");
        this.name = "";
        this.parentName = "";
        this.phoneNumber = -1;
        this.address = "";
        this.age = -1;

        this.name = vals[0];

        this.parentName = vals[1];
        try {
            this.phoneNumber = Long.parseLong(vals[2]);
        } catch (Exception e) {
            System.err.println("Error while parsing phone number" + vals[2]);
        }
        this.address = vals[3];

        try {
            this.age = Integer.parseInt(vals[4]);
        } catch (Exception e) {
            System.err.println("Error while parsing age" + vals[4]);
        }
        try {
            this.gpa = Double.parseDouble(vals[5]);
        } catch (Exception e) {
            System.err.println("Error while parsing gpa" + vals[5]);
        }
        try {
            this.sid = Integer.parseInt(vals[6]);
        } catch (Exception e) {
            System.err.println("Error while parsing student id" + vals[6]);
        }
    }
    @Override
    public String toString()
    {
        return ((Integer)this.getSId()).toString();
    }
    public String toCSV() {
        return super.toCSV() + "," + this.getGpa() + "," + this.getSId();
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getSId() {
        return sid;
    }

    public void setSId(int sId) {
        this.sid = sId;
    }
}
