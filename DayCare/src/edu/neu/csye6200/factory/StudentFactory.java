package edu.neu.csye6200.factory;

import java.util.Map;

import edu.neu.csye6200.Person;

public class StudentFactory implements Factory{
	Map<Integer,Person> personMap=null;

	StudentFactory(){}
	@Override
	public Person getPerson(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
