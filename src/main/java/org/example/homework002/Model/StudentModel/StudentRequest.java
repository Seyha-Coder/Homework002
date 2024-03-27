package org.example.homework002.Model.StudentModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework002.Model.CourseModel.Course;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    String name;
    String email;
    String phoneNumber;
    List<Integer> courseId;
}
