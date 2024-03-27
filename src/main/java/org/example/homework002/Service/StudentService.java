package org.example.homework002.Service;

import org.example.homework002.Model.StudentModel.Student;
import org.example.homework002.Model.StudentModel.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Integer offset, Integer limit);
    Student getStudentById(int id);
    Student insertStudent(StudentRequest studentRequest);
    Student updateStudent(int id, StudentRequest studentRequest);
    void deleteStudent(int id);
}
