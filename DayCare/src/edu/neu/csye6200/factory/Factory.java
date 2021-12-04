package edu.neu.csye6200.factory;

import edu.neu.csye6200.Person;

public interface Factory {
	public Person getPerson(String type);
	public void loadPersons(String fileName);
	public void addPerson(Person person);
}
