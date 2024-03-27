package org.example.homework002.Controller;

import org.example.homework002.Model.StudentModel.Student;
import org.example.homework002.Model.StudentModel.StudentRequest;
import org.example.homework002.Model.StudentModel.StudentResponse;
import org.example.homework002.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @GetMapping
    public ResponseEntity<?> getAllStudent(
            @RequestParam(defaultValue = "1") Integer offset,
            @RequestParam(defaultValue = "2") Integer limit){
        List<Student> students = studentService.getAllStudent(offset,limit);
        StudentResponse studentResponse = new StudentResponse<>(
                "All students have been successfully fetched.",
                students,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(studentResponse);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);

        StudentResponse studentResponse = new StudentResponse<>(
                "The student have been successfully found.",
                studentService.getStudentById(id),
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(studentResponse);
    }
    @PostMapping
    public ResponseEntity<?> insertStudent(@RequestBody StudentRequest studentRequest){
        Student student = studentService.insertStudent(studentRequest);
        StudentResponse<Student> studentResponse = new StudentResponse<>(
                "The Student has been successfully added.",
                student,
                "CREATED",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody StudentRequest studentRequest){
        Student student = studentService.updateStudent(id,studentRequest);
        StudentResponse<Student> studentResponse = new StudentResponse<>(
                "The Student has been successfully updated.",
                student,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        StudentResponse<Student> studentResponse = new StudentResponse<>(
                "The Student has been successfully deleted.",
                null,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }
}
