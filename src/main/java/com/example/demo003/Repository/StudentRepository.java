package com.example.demo003.Repository;

import com.example.demo003.Student.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentClass, Long> {

    Optional<StudentClass> findStudentClassByEmail(String email);

}