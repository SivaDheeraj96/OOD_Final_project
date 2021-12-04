package edu.neu.csye6200.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;
import edu.neu.csye6200.student.Student;

public class StudentFactory implements Factory{
	private static Map<Integer,Person> personMap=null;
	private static final String file = "edu/neu/csye6200/inputData/studentData.txt";
	private static final StudentFactory instance = new StudentFactory(); 
	private StudentFactory(){}
	@Override
	public Person getPerson(String type) {
		if(personMap == null) {
			populate();
		}
		return null;
	}
	private void populate() {
		personMap = new HashMap<Integer,Person>();
		FileUtil.getFileData(file).stream().map((x) -> new Student(x)).forEach((x) -> {personMap.put(x.getSId(), x);});
	}
	@Override
	public void loadPersons(String fileName) {
		List<String> data = FileUtil.getFileData(fileName);
		data.stream().map((x) -> new Student(x)).forEach((x) -> {personMap.put(x.getSId(), x);});
	}
	@Override
	public void addPerson(Person person) {
	}
	
	public static Factory getInstance() {
		return instance;
	}

}
