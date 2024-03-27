package org.example.homework002.Service;

import org.example.homework002.Model.InstructorModel.Instructor;
import org.example.homework002.Model.InstructorModel.InstructorRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructor(Integer offset, Integer limit);
    Instructor getInstructorById(int id);
    Instructor insertInstructor(InstructorRequest instructorRequest);
    void updateInstructor(int id,InstructorRequest instructorRequest);
    void deleteInstructor(int id);
}
