package org.example.homework002.Model.CourseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework002.Model.InstructorModel.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    String name;
    String description;
    int instructor;
}
