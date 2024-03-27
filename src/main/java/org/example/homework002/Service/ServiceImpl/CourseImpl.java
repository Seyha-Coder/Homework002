package org.example.homework002.Service.ServiceImpl;

import org.example.homework002.Model.CourseModel.Course;
import org.example.homework002.Model.CourseModel.CourseRequest;
import org.example.homework002.Repository.CourseRepository;
import org.example.homework002.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService {

    private CourseRepository courseRepository;
    public CourseImpl(CourseRepository courseRepository){
        this.courseRepository =courseRepository;
    }
    @Override
    public List<Course> getAllCourse(Integer offset, Integer limit) {
        return courseRepository.getAllCourse(offset,limit);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public Course insertCourse(CourseRequest courseRequest) {
       return courseRepository.insertCourse(courseRequest);
    }

    @Override
    public void updateCourse(int id, CourseRequest courseRequest) {
        courseRepository.updateCourse(id, courseRequest);
    }

    @Override
    public Course deleteCourse(int id) {
        return courseRepository.deleteCourse(id);
    }
}
