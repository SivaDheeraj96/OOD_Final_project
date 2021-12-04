package edu.neu.csye6200.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;
import edu.neu.csye6200.Teacher;

public class TeacherFactory implements Factory{
	private static final Map<Integer,Person> personMap=new HashMap<Integer,Person>();
	{
		FileUtil.getFileData(file).stream().map((x) -> new Teacher(x)).forEach((x) -> {personMap.put(x.getTId(), x);});
	}
	private static final String file = "edu/neu/csye6200/inputData/techerData.txt";
	private static final TeacherFactory instance = new TeacherFactory(); 
	private TeacherFactory(){}
	@Override
	public Person getPerson(String type) {
		return personMap.get(Integer.parseInt(type));
	}
	@Override
	public void loadPersons(String fileName) {
		List<String> data = FileUtil.getFileData(fileName);
		data.stream().map((x) -> new Teacher(x)).forEach((x) -> {personMap.put(x.getTId(), x);});
	}
	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
	}
	
	public static Factory getInstance() {
		return instance;
	}
}
