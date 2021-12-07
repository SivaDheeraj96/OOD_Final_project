package edu.neu.csye6200.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;

public class StudentModel {
	private Map<Integer,Student> personMap=null;
	private String fileInput = "edu/neu/csye6200/inputData/studentData.txt";

    public StudentModel(String filePath) {
        this.fileInput = filePath;
    }
	public Student getStudent(int id) {
		if(personMap == null) {
			populate();
		}
		return personMap.get(id);
	}
	private void populate() {
		personMap = new HashMap<Integer,Student>();
		FileUtil.getFileData(this.fileInput).stream().map((x) -> new Student(x)).forEach((x) -> {personMap.put(x.getSId(), x);});
	}
	public void loadPersons(String fileName) {
		List<String> data = FileUtil.getFileData(fileName);
		data.stream().map((x) -> new Student(x)).forEach((x) -> {personMap.put(x.getSId(), x);});
	}
	public void addPerson(Person person) {
	}
	
	protected List<Student> getStudents(){
		return new ArrayList<>(this.personMap.values());
	}

}
