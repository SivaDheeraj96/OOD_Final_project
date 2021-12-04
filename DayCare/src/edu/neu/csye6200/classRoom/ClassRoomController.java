package edu.neu.csye6200.classRoom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class ClassRoomController {
	ClassRoomModel model;
	ClassRoomView view;
	
	public ClassRoomController(ClassRoomModel model,ClassRoomView view) {
		this.model =  model;
		this.view = view;
	}
	
	public ClassRoom getClassRoom(int id) {
		return this.model.getClassRoom(id);
	}
	
	public void addClassRoom(ClassRoom classRoom) {
		this.model.addClassRoom(classRoom);
	}
	
	public void updateView() {
		this.view.updateDisplay();
	}
	
	public List<ClassRoom> searchClassRoom(Map<String, String> criteria){
		List<ClassRoom> result = new ArrayList<ClassRoom>();
		
		Predicate<ClassRoom> filter = ( x)->{
			Iterator<String> ite = criteria.keySet().iterator();
			while (ite.hasNext()) {
				String type = ite.next();
				String value = criteria.get(type);
				switch(type) {
				case"ID":
					if(!(Integer.toString(x.getId()).toLowerCase().contains(value))) {
						return false;
					}
					break;
				case "NAME":
					if(!(x.getName().toLowerCase().contains(value))) {
						return false;
					}
					break;
				}
			}
			return true;
		};
		this.model.getClassRooms().stream().filter(filter).forEach(result::add);
		return result;
	}
}
