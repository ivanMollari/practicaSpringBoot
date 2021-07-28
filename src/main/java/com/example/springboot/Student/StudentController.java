package com.example.springboot.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping()
    public void registerNewStudent(@RequestBody StudentModel studentModel){
        studentService.addNewStudent(studentModel);
    }

}
