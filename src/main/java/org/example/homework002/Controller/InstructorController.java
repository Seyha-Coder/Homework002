package org.example.homework002.Controller;

import org.example.homework002.Model.InstructorModel.Instructor;
import org.example.homework002.Model.InstructorModel.InstructorRequest;
import org.example.homework002.Model.InstructorModel.InstructorResponse;
import org.example.homework002.Service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {
    InstructorService instructorService;
    public InstructorController(InstructorService instructorService){
        this.instructorService=instructorService;
    }
    @GetMapping
    public ResponseEntity<?> getAllInstructor(
        @RequestParam(defaultValue = "1") Integer offset,
        @RequestParam(defaultValue = "4") Integer limit
    ){
        List<Instructor> instructor =  instructorService.getAllInstructor(offset,limit);
        InstructorResponse instructorResponse = new InstructorResponse<>(
                "All Instructors have been successfully fetched.",
                instructor,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(instructorResponse);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable int id){
        Instructor instructor= instructorService.getInstructorById(id);
        InstructorResponse instructorResponse = new InstructorResponse<>(
                "The instructor has been successfully founded.",
                instructor,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(instructorResponse);
    }
    @PostMapping
    public ResponseEntity<?> insertInstructor(@RequestBody InstructorRequest instructorRequest){

        InstructorResponse<Instructor> instructorResponse = new InstructorResponse<>(
                "The instructor has been successfully added.",
                instructorService.insertInstructor(instructorRequest),
                "CREATED",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorResponse);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateInstructor(@PathVariable int id, @RequestBody InstructorRequest instructorRequest){
        instructorService.updateInstructor(id,instructorRequest);
        InstructorResponse instructorResponse = new InstructorResponse<>(
                "The instructor has been successfully updated.",
                instructorService.getInstructorById(id),
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(instructorResponse);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInstructor(@PathVariable int id){
        instructorService.deleteInstructor(id);
        InstructorResponse instructorResponse = new InstructorResponse<>(
                "The instructor has been successfully removed.",
                null,
                "OK",
                LocalDateTime.now()
        );
        return ResponseEntity.ok(instructorResponse);
    }
}
