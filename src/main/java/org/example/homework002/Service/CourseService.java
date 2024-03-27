package org.example.homework002.Service;

import org.example.homework002.Model.CourseModel.Course;
import org.example.homework002.Model.CourseModel.CourseRequest;
import org.example.homework002.Model.InstructorModel.Instructor;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse(Integer offset, Integer limit);
    Course getCourseById(int id);
    Course insertCourse(CourseRequest courseRequest);
    void updateCourse(int id, CourseRequest courseRequest);
    Course deleteCourse(int id);
}
