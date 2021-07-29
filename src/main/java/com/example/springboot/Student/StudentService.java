package com.example.springboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(StudentModel studentModel) {
        Optional<StudentModel> student = studentRepository.findStudent(studentModel.getEmail());
        if(student.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(studentModel);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id: " + studentId + " does not exists");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        StudentModel studentModel = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException("student with id: "+ studentId + "does not exists"));

        if(name != null && name.length() > 0 && !Objects.equals(studentModel.getName(),name)){
            studentModel.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(studentModel.getEmail(),email)){
            Optional<StudentModel> studentOptional = studentRepository.findStudent(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            studentModel.setEmail(email);
        }

    }
}
