package edu.neu.csye6200.classRoom;

import edu.neu.csye6200.classRoomGroup.ClassRoomGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassRoom {

	private int id;
	private String name;
	private List<ClassRoomGroup> groups = new ArrayList<ClassRoomGroup>();
        private boolean isFull= false;
	
	protected ClassRoom(String data) {
		
            this.id =-1;
            this.name ="";
            
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

    public List<ClassRoomGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<ClassRoomGroup> groups) {
        this.groups = groups;
    }
        
    @Override
    public String toString()
    {
        return this.getId()+","+this.getName()+","+this.getGroups().stream().map(x -> ((Integer)x.getId()).toString()).collect(Collectors.joining(","));
    }
	
}
