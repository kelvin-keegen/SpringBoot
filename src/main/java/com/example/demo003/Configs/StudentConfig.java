package com.example.demo003.Configs;

import com.example.demo003.Repository.StudentRepository;
import com.example.demo003.Student.StudentClass;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner mcommandLineRunner(StudentRepository mrepository) {

        return args -> {

            StudentClass Cate = new StudentClass(
                    "Cate",
                    LocalDate.of(2001, JANUARY,5),
                    "Cate@kmail.com"
           );

            StudentClass Keegan = new StudentClass(
                    "Keegan",
                    LocalDate.of(1996, JANUARY,7),
                    "Keegan@kmail.com"
            );

            StudentClass Katarina = new StudentClass(
                    "Katarina",
                    LocalDate.of(1999, JANUARY,10),
                    "Katarina@kmail.com"
            );

            mrepository.saveAll(
                    List.of(Cate,Keegan,Katarina)
            );
        };
    }
}
