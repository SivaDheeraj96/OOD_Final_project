package edu.neu.csye6200.classRoom;

import java.util.HashMap;
import java.util.Map;

import edu.neu.csye6200.FileUtil;

public class CourseDirectory {

	private Map<Integer, Course> data = new HashMap<Integer, Course>();
	private static final String fileName = "edu/neu/csye6200/inputData/course.txt";
	{
		FileUtil.getFileData(fileName).stream().map(x -> new Course(x)).forEach( x -> data.put(x.getCourseId(), x));
	}
}
