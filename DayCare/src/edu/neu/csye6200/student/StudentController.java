package edu.neu.csye6200.student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.health.VaccineRecord;

public class StudentController {
	
	StudentModel model;
	StudentView view;
	
	StudentController(StudentModel model, StudentView view){
		this.model  = model;
		this.view = view;
	}
	
	public void updateView() {
		this.view.updateView();
	}
	
	public void addStudent(Person p) {
		this.model.addPerson(p);
	}
	
	public Student getStudent(int id) {
		return this.model.getStudent(id);
	}
	
	public List<Student> searchStudent(Map<String, String> criteria){
		List<Student> result = new ArrayList<Student>();
		Predicate<Student> filter = ( x)->{
			Iterator<String> ite = criteria.keySet().iterator();
			while (ite.hasNext()) {
				String type = ite.next();
				String value = criteria.get(type);
				switch(type) {
				case"ID":
					if(!(Integer.toString(x.getSId()).toLowerCase().contains(value))) {
						return false;
					}
					break;
				case "NAME":
					if(!(x.getName().toLowerCase().contains(value))) {
						return false;
					}
					break;
				case "AGE":
					if(!(Double.toString(x.getGpa()).toLowerCase().contains(value))) {
						return false;
					}
					break;
				}
			}
			return true;
		};
		this.model.getStudents().stream().filter(filter).forEach(result::add);
		return result;
	}
	
	public void addVaccineRecord(Student s, List<VaccineRecord> records) {
		records.stream().forEach(s::addVaccineRecord);
		//need to add write to file cases
	}
}
