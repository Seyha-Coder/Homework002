package org.example.homework002.Controller;

import org.example.homework002.Model.CourseModel.Course;
import org.example.homework002.Model.CourseModel.CourseRequest;
import org.example.homework002.Model.CourseModel.CourseResponse;
import org.example.homework002.Model.InstructorModel.Instructor;
import org.example.homework002.Model.InstructorModel.InstructorResponse;
import org.example.homework002.Service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping
    public ResponseEntity<?> getAllCourse(
            @RequestParam (defaultValue = "1") Integer offset,
            @RequestParam (defaultValue = "4") Integer limit
    ){
        List<Course> courses = courseService.getAllCourse(offset,limit);
        CourseResponse courseResponse = new CourseResponse(
                "All Courses have been successfully fetched.",
                courses,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(courseResponse);

    }
    @GetMapping("{id}")
    public ResponseEntity getCourseById(int id){
        Course course = courseService.getCourseById(id);
        CourseResponse courseResponse = new CourseResponse(
                "The Courses have been successfully fetched.",
                course,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(courseResponse);
    }
    @PostMapping
    public ResponseEntity<?> insertCourse(@RequestBody CourseRequest courseRequest){

        CourseResponse <Course> courseResponse = new CourseResponse<>(
                "The course has been successfully added.",
                courseService.insertCourse(courseRequest),
                "CREATED",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody CourseRequest courseRequest){
        courseService.updateCourse(id,courseRequest);
        courseService.updateCourse(id,courseRequest);
        CourseResponse courseResponse = new CourseResponse(
                "The course has been successfully updated.",
                courseService.getCourseById(id),
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(courseResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        Course course = courseService.deleteCourse(id);

        CourseResponse courseResponse = new CourseResponse(
                "The course has been successfully removed.",
                null,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(courseResponse);
    }

}
