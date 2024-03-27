package org.example.homework002.Service.ServiceImpl;

import org.example.homework002.Model.InstructorModel.Instructor;
import org.example.homework002.Model.InstructorModel.InstructorRequest;
import org.example.homework002.Repository.InstructorRepository;
import org.example.homework002.Service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorImpl implements InstructorService {
    InstructorRepository instructorRepository;
    public InstructorImpl(InstructorRepository instructorRepository){
        this.instructorRepository=instructorRepository;
    }
    @Override
    public List<Instructor> getAllInstructor(Integer offset, Integer limit) {
        return instructorRepository.getAllInstructor(offset,limit);
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor insertInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.insertInstructor(instructorRequest);
    }

    @Override
    public void updateInstructor(int id, InstructorRequest instructorRequest) {
        instructorRepository.updateInstructor(id,instructorRequest);
    }

    @Override
    public void deleteInstructor(int id) {
        instructorRepository.deleteInstructor(id);
    }
}
