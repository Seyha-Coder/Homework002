package org.example.homework002.Model.InstructorModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    int instructorId;
    String instructorName;
    String email;
}
