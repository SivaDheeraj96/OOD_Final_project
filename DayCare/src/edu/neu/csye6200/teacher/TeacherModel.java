package edu.neu.csye6200.teacher;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dheeraj
 */
public class TeacherModel {

    private final String inputFilePath ;
    
    private final List<Person> teacherList = new ArrayList();
    public TeacherModel(String filePath) {
        this.inputFilePath = filePath;
        FileUtil.getFileData(filePath).stream().map(x -> new Teacher(x)).forEach(teacherList::add);
    }

    protected List<Person> getTeacherList() {
        return teacherList;
    }
    protected void addTeacher(String name, String parentName, long phoneNumber, String address,int age, int salary, int tId){
        Teacher t = new Teacher(name, parentName, phoneNumber, address, age, salary, tId);
        teacherList.add(t);
        FileUtil.appendEntryToFile(inputFilePath,t.toCSV());
    }
    
    protected void addTeacher(Person t){
        teacherList.add(t);
        FileUtil.appendEntryToFile(inputFilePath,t.toCSV());
    }
    
    protected void removeTeacher(Person t){
        teacherList.remove(t);
        FileUtil.removeEntryInFile(inputFilePath, t.toCSV());
    }
    
    protected void updateTeacher(Person oldTeacher, Person newTeacher)
    {
        teacherList.remove(oldTeacher);
        teacherList.add(newTeacher);
        FileUtil.modifyEntryInFile(inputFilePath, oldTeacher.toCSV(), newTeacher.toCSV());
    }
    
    protected List<Person> getUnassignedTeacherList(){
        List<Person> list = new ArrayList<>();
        teacherList.stream().filter(x -> x.getIsAssigned()).forEach(list::add);
        return list;
        
    }
    
}
