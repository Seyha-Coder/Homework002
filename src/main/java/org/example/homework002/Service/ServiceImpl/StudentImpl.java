package org.example.homework002.Service.ServiceImpl;

import org.example.homework002.Model.StudentModel.Student;
import org.example.homework002.Model.StudentModel.StudentRequest;
import org.example.homework002.Repository.StudentRepository;
import org.example.homework002.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    StudentRepository studentRepository;
    public StudentImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAllStudent(Integer offset, Integer limit) {
        return studentRepository.getAllStudent(offset,limit);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    @Override
    public Student insertStudent(StudentRequest studentRequest) {
        Integer student = studentRepository.insertStudent(studentRequest);
        for(Integer courseId : studentRequest.getCourseId()){
            studentRepository.insertStudentCourse(student,courseId);
        }
        return getStudentById(student);
    }

    @Override
    public Student updateStudent(int id, StudentRequest studentRequest) {
        studentRepository.deleteStudentCourseByStudentId(id);
        for(int courseId : studentRequest.getCourseId()){
            studentRepository.insertStudentCourse(id,courseId);
        }
        studentRepository.updateStudent(id,studentRequest);
        return getStudentById(id);
    }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteStudentById(id);
    }
}
