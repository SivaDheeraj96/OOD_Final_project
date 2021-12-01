package edu.neu.csye6200.factory;

import edu.neu.csye6200.Person;

public interface Factory {
	public Person getPerson(String type);

}
