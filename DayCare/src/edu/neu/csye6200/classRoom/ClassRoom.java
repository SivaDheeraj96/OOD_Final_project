package edu.neu.csye6200.classRoom;

import edu.neu.csye6200.classRoomGroup.ClassRoomGroup;
import edu.neu.csye6200.student.Student;
import edu.neu.csye6200.teacher.Teacher;
import java.util.ArrayList;
import java.util.List;

public class ClassRoom {

	private int id;
	private String name;
	private List<ClassRoomGroup> groups = new ArrayList<ClassRoomGroup>();
        private boolean isFull= false;
	
	protected ClassRoom(String data) {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIsFull(boolean isFull){
            this.isFull = isFull;
        }
        public boolean getIsFull(){
            return this.isFull;
        }
        
	
}
