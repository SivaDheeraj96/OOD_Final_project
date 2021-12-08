package edu.neu.csye6200.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;

public class PersonFactory implements Factory{
	private static Map<String,Person> personMap=null;
	private static final String file = "edu/neu/csye6200/inputData/personData.txt";
	private static final PersonFactory instance = new PersonFactory(); 
	PersonFactory(){}
	@Override
	public Person getPerson(String type) {
		personMap = new HashMap<String,Person>();
		FileUtil.getFileData(file).stream().map((x) -> new Person(x)).forEach((x) -> {personMap.put(x.getName(), x);});
		return null;
	}
	@Override
	public void loadPersons(String fileName) {
		List<String> data = FileUtil.getFileData(fileName);
		data.stream().map((x) -> new Person(x)).forEach((x) -> {personMap.put(x.getName(), x);});
	}
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
	}
	
	public static Factory getInstance() {
		return instance;
	}
}
