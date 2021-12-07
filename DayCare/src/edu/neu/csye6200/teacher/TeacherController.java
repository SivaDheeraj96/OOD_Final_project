/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.teacher;

import edu.neu.csye6200.FileUtil;
import edu.neu.csye6200.Person;
import java.util.List;
import java.util.Optional;

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
    
}
