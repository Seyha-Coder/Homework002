package org.example.homework002.Repository;

import org.apache.ibatis.annotations.*;
import org.example.homework002.Model.InstructorModel.Instructor;
import org.example.homework002.Model.InstructorModel.InstructorRequest;

import java.util.List;

    @Mapper
    public interface InstructorRepository {

        @Select("""
            SELECT * FROM instructors LIMIT #{limit} OFFSET (#{offset}-1) * (#{limit})
        """)
        @Results(id="instructorMapping" , value = {
                @Result(property = "instructorId", column = "instructor_id"),
                @Result(property = "instructorName", column = "instructor_name")
        })
        List<Instructor> getAllInstructor(@Param("offset") Integer offset,@Param("limit") Integer limit);

        @ResultMap("instructorMapping")
        @Select("""
        SELECT * FROM instructors WHERE instructor_id =#{id}
        """)
        Instructor getInstructorById(int id);
        @Select("""
            INSERT INTO instructors(instructor_name,email) VALUES(#{instructor.instructorName},#{instructor.email}) RETURNING *
        """)
        @ResultMap("instructorMapping")
        Instructor insertInstructor(@Param("instructor") InstructorRequest instructorRequest);


        @Update("""
            UPDATE instructors SET instructor_name=#{instructors.instructorName},email=#{instructors.email}
            WHERE instructor_id = #{id} 
        """)
        void updateInstructor(int id,@Param("instructors") InstructorRequest instructorRequest);

        @Select("""
            DELETE FROM instructors WHERE instructor_id = #{id}
        """)
        void deleteInstructor(int id);
    }
