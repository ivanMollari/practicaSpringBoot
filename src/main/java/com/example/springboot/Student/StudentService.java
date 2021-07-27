package com.example.springboot.Student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<StudentModel> getStudents(){
        return List.of(
                new StudentModel(
                        1L,
                        "Carlos",
                        "carlos@gmal.com",
                        21,
                        LocalDate.of(2000, Month.JANUARY,5)
                )
        );
    }

}
