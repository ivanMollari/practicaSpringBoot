package com.example.springboot.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            StudentModel carlos = new StudentModel(
                    "Carlos",
                    "carlos@gmal.com",
                    LocalDate.of(2000, JANUARY,5)
            );

            StudentModel camila = new StudentModel(
                    "Camila",
                    "cami@gmal.com",
                    LocalDate.of(1997, JANUARY,9)
            );

            studentRepository.saveAll(List.of(carlos,camila));
        };
    }
}
