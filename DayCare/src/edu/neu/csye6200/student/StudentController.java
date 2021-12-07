package edu.neu.csye6200.student;

import edu.neu.csye6200.FileUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import edu.neu.csye6200.Person;
import java.util.Optional;

public class StudentController {

    StudentModel model;
    StudentView view;

    public StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void addStudent(Person p) {
        this.model.addStudent(p);
        this.view.updateView();
    }

    public List<Person> searchStudent(Map<String, String> criteria) {
        List<Person> result = new ArrayList<>();
        Predicate<Person> filter = (x) -> {
            Iterator<String> ite = criteria.keySet().iterator();
            while (ite.hasNext()) {
                String type = ite.next();
                String value = criteria.get(type);
                switch (type) {
                    case "ID":
                        if (!(Integer.toString(x.getAge()).toLowerCase().contains(value))) {
                            return false;
                        }
                        break;
                    case "NAME":
                        if (!(x.getName().toLowerCase().contains(value))) {
                            return false;
                        }
                        break;
                    case "AGE":
                        if (!(Double.toString(x.getAge()).toLowerCase().contains(value))) {
                            return false;
                        }
                        break;
                }
            }
            return true;
        };
        this.model.getStudents().stream().filter(filter).forEach(result::add);
        return result;
    }
    
    public void removeStudent(Person s)
    {
        this.model.removeStudent(s);
        this.view.updateView();
    }
    
    public void modifyTeacher(Student s, String name, String parentName, long phoneNumber, String address,int age,double gpa, int sid)
    {
        Student tempStudent = new Student(name, parentName, phoneNumber, address,age,gpa,sid);
        this.model.updateStudent(s, tempStudent);
        this.view.updateView();
    }
    
    public List<Person> getUnassignedStudent()
    {
        return this.model.getUnassignedStudentList();
    }
    public void loadStudentFromCSV(String filePath)
    {
        FileUtil.getFileData(filePath).stream().map(x -> new Student(x)).forEach(this.model::addStudent);
    }
    
    public Person getStudentById(int id)
    {
        Optional<Person> temp = this.model.getStudents().stream().filter(x -> ((Student)x).getSId()==id).findFirst();
        return temp.get();
    }

}
