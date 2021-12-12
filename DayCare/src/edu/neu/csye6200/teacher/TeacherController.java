/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.teacher;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;
import edu.neu.csye6200.student.Student;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author dheeraj
 */
public class TeacherController {
    
    private final TeacherModel model;
    private final TeacherView view;
    
    public TeacherController(TeacherModel model, TeacherView view){
        this.model = model;
        this.view = view;
    }
    
    public void addTeacher(String name, String parentName, long phoneNumber, String address,int age, int salary, int tId){
        this.model.addTeacher(name, parentName, phoneNumber, address, age, salary, tId);
        this.view.updateView();
    }
    
    public void removeTeacher(Teacher t){
        this.model.removeTeacher(t);
        this.view.updateView();
    }
    
    public void modifyTeacher(Teacher t, String name, String parentName, long phoneNumber, String address,int age, int salary, int tId){
        Teacher tempTeacher = new Teacher(name, parentName, phoneNumber, address, age, salary, tId);
        this.model.updateTeacher(t, tempTeacher);
        this.view.updateView();
    }
    
    public void modifyTeacher(Teacher oldTeacher, Teacher newTeacher){
        this.model.updateTeacher(oldTeacher, newTeacher);
        this.view.updateView();
    }
    
    public List<Person> getUnassignedTeacher(){
        return this.model.getUnassignedTeacherList();
    }
    
    public Person getTeacherById(int id)
    {
        Optional<Person> temp = this.model.getTeacherList().stream().filter(x -> ((Teacher)x).getTId()==id).findFirst();
        return temp.get();
    }
    public void loadTeacherFromCSV(String filePath)
    {
        FileUtil.getFileData(filePath).stream().map(x ->new Teacher(x)).forEach(this.model::addTeacher);
    }
    
     public List<Person> searchTeacher(Map<String, String> criteria) {
        List<Person> result = new ArrayList<>();
        Predicate<Person> filter = (x) -> {
            Iterator<String> ite = criteria.keySet().iterator();
            while (ite.hasNext()) {
                String type = ite.next();
                String value = criteria.get(type);
                switch (type) {
                    case "ID":
                        if (!(Integer.toString(((Teacher)x).getTId()).toLowerCase().contains(value))) {
                            return false;
                        }
                        break;
                    case "NAME":
                        if (!(x.getName().toLowerCase().contains(value))) {
                            return false;
                        }
                        break;
                    case "PARENT_NAME":
                        if (x.getParentName().toLowerCase().contains(value)) {
                            return false;
                        }
                        break;
                    case "PHONE_NUMBER":
                        if (x.getParentName().toLowerCase().contains(value)) {
                            return false;
                        }
                        break;
                }
            }
            return true;
        };
        this.model.getTeacherList().stream().filter(filter).forEach(result::add);
        return result;
    }
}
