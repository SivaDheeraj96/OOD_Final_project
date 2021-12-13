/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.neu.csye6200;

import edu.neu.csye6200.classRoom.ClassRoomController;
import edu.neu.csye6200.classRoomGroup.ClassRoomGroupController;
import edu.neu.csye6200.health.ImmunizationController;
import edu.neu.csye6200.review.Rating;
import edu.neu.csye6200.review.RatingController;
import edu.neu.csye6200.student.StudentController;
import edu.neu.csye6200.teacher.TeacherController;

/**
 *
 * @author dheeraj
 */
public interface University {
    public StudentController getStudentController();
    public TeacherController getTeacherController();
    public ClassRoomGroupController getClassRoomGroupController();
    public ClassRoomController getClassRoomController();
    public ImmunizationController getImmunizationController();
    public RatingController getRatingController();
}
