package org.example.homework002.Model.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework002.Model.CourseModel.Course;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    String email;
    String phoneNumber;
    List<Course> courses;
}
