package org.example.homework002.Repository;


import org.apache.ibatis.annotations.*;
import org.example.homework002.Model.StudentModel.Student;
import org.example.homework002.Model.StudentModel.StudentRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("""
        SELECT s.student_id,s.student_name,s.email, s.phone_number FROM students s INNER JOIN student_course on s.student_id = student_course.student_id
        LIMIT #{limit} OFFSET (#{offset}-1) * #{limit}
    """)
    @Results(id = "studentMapping", value = {
            @Result(property = "id",column = "student_id"),
            @Result(property = "name", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses",column = "student_id",
            many = @Many(select = "org.example.homework002.Repository.CourseRepository.getCourseByStudentId"))
    })
    List<Student> getAllStudent(@Param("offset") Integer offset,@Param("limit") Integer limit);


    @Select("""
        SELECT s.* FROM students s INNER JOIN student_course on s.student_id = student_course.student_id
        WHERE s.student_id = #{id} limit 1 
        
    """)
    @ResultMap("studentMapping")
    Student getStudentById(int id);

    @Select("""
        INSERT INTO students (student_name, email, phone_number) 
        VALUES (#{student.name},#{student.email},#{student.phoneNumber}) RETURNING student_id;
    """)
//    @ResultMap("studentMapping")
    Integer insertStudent(@Param("student")StudentRequest studentRequest);

    @Insert("""
    INSERT INTO student_course(student_id, course_id)  VALUES (#{studentId},#{courseId})
    """)
    void insertStudentCourse(int studentId,int courseId);

    @ResultMap("studentMapping")
    @Update("""
     UPDATE students SET student_name = #{student.name},email= #{student.email},phone_number = #{student.phoneNumber} WHERE student_id = #{id}
    """)
    void updateStudent(int id,@Param("student") StudentRequest studentRequest);

    @Delete("""
        DELETE FROM student_course WHERE student_id = #{id};
    """)
    void deleteStudentCourseByStudentId(int id);

    @Delete("""
        DELETE FROM students WHERE student_id = #{id};
    """)
    void deleteStudentById(int id);
}
