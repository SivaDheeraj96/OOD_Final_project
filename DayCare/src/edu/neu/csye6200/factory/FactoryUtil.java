package edu.neu.csye6200.factory;

public class FactoryUtil {
public static Factory getFactory(String type) {
	switch(type) {
	case "Student":
		return StudentFactory.getInstance();
	case "Teacher":
		return TeacherFactory.getInstance();
	case "Person":
		return new PersonFactory();
	default:
			throw new RuntimeException("invalid type sent");
	}
}
	
}
