/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200.classRoomGroup;

import edu.neu.csye6200.Person;
import edu.neu.csye6200.student.Student;
import edu.neu.csye6200.student.StudentController;
import edu.neu.csye6200.teacher.Teacher;
import edu.neu.csye6200.teacher.TeacherController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dheeraj
 */
public class ClassRoomGroup {
    private static final Logger LOGGER = Logger.getLogger(ClassRoomGroup.class.getName());
    private int id;
    private Person teacher;
    private List<Person> students ;
    
    private boolean isAssigned = false;
    
    ClassRoomGroup(String csvString,TeacherController teacherController, StudentController studentController)
    {
        this.id = -1;
        this.teacher = null;
        this.students = new ArrayList<>();
        
        String[] data = csvString.split(",");
        
        try{
            this.id = Integer.parseInt(data[0]);
        }
        catch(Exception e)
        {
            LOGGER.log(Level.SEVERE,"error while parsing the classroomgroup id",e);
        }
        
        try{
            this.teacher = teacherController.getTeacherById(Integer.parseInt(data[1]));
            this.teacher.setIsAssigned(true);
        }
        catch(Exception e)
        {
            LOGGER.log(Level.SEVERE,"error while creating the teacher ",e);
        }
        
        try
        {
            Arrays.asList(data[2].split("_")).stream()
                    .map(x -> studentController.getStudentById(Integer.parseInt(x)))
                    .forEach(x -> {x.setIsAssigned(true);students.add(x);});
        }
        catch(Exception e)
        {
            LOGGER.log(Level.SEVERE,"error while creating students",e);
        }    
    }
    protected ClassRoomGroup(int id, Teacher teacher, List<Person> students)
    {
        this.id = id;
        this.teacher = teacher;
        this.students = students;
        this.teacher.setIsAssigned(true);
        students.stream().forEach(x -> x.setIsAssigned(true));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(boolean isAssigned) {
        this.isAssigned = isAssigned;
    }
    @Override
    public String toString()
    {
        return ((Integer)this.getId()).toString();
    }
    public String toCSV()
    {
        StringBuilder studentIds = new StringBuilder();
        this.getStudents().stream()
                .map(x -> ((Student)x).getSId())
                .forEach(x -> studentIds.append(x).append("_"));
        String substring = studentIds.toString().substring(0, studentIds.toString().length()-1);
        return this.getId()+","+((Integer)((Teacher)this.getTeacher()).getTId()).toString()+","+substring;
    }
    
}
