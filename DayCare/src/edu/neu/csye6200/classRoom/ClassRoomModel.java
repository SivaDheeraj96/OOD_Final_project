package edu.neu.csye6200.classRoom;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye6200.FileUtil;

public class ClassRoomModel {

    private static final List< ClassRoom> data = new ArrayList<ClassRoom>();
    private String inputData = "edu/neu/csye6200/inputData/classRoom.txt";
    {
            FileUtil.getFileData(this.inputData).stream().map(x->new ClassRoom(x)).forEach(data::add);
    }

    public ClassRoomModel(String filePath) {
        this.inputData = filePath;
    }
	
    protected ClassRoom getClassRoom(int id) {
            return data.get(id);
    }

    public void addClassRoom(ClassRoom classRoom) {
            // TODO Auto-generated method stub

    }
    public List<ClassRoom> getClassRooms(){
            return data;
    }
        
        
}
