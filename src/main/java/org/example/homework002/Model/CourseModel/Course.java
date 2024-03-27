package org.example.homework002.Model.CourseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.homework002.Model.InstructorModel.Instructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    int id;
    String name;
    String description;
   private Instructor instructor;
}
