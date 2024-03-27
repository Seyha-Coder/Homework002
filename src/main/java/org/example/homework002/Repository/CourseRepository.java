package org.example.homework002.Repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.Model.CourseModel.Course;
import org.example.homework002.Model.CourseModel.CourseRequest;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Select("""
    SELECT * FROM courses LIMIT #{limit} OFFSET (#{offset}-1) * #{limit}
    """)
    @Results(id="courseMapping" , value = {
            @Result(property = "id", column = "course_id"),
            @Result(property = "name", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id",
            one = @One(select = "org.example.homework002.Repository.InstructorRepository.getInstructorById"))
    })
    List<Course> getAllCourse(@Param("offset") Integer offset,@Param("limit") Integer limit);

    @Select("""
        SELECT * FROM courses WHERE course_id = #{id}
    """)
    @ResultMap("courseMapping")
    Course getCourseById(int id);

    @Select("""
        INSERT INTO courses (course_name, description, instructor_id) VALUES (#{courseRequest.name},#{courseRequest.description},#{courseRequest.instructor}) RETURNING *
    """)
    @ResultMap("courseMapping")
    Course insertCourse(@Param("courseRequest") CourseRequest courseRequest);


    @Update("""
        UPDATE courses SET course_name = #{courseRequest.name},description= #{courseRequest.description},
        instructor_id = #{courseRequest.instructor} WHERE course_id = #{id}
    """)

    void updateCourse( int id,@Param("courseRequest") CourseRequest courseRequest);

    @Select("""
        DELETE FROM courses WHERE course_id=#{id}
    """)
    Course deleteCourse(int id);

    @Select("""
    
    SELECT c.* FROM courses c INNER JOIN student_course sc on c.course_id = sc.course_id
    WHERE sc.student_id= #{studentId} ORDER BY c.course_id;

    """)
    @ResultMap("courseMapping")

    List<Course> getCourseByStudentId(Integer studentId);
}
