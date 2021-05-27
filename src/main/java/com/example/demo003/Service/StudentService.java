package com.example.demo003.Service;

import com.example.demo003.Student.StudentClass;
import com.example.demo003.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository mStudentRepository;



    @Autowired
    public StudentService(StudentRepository mStudentRepository) {
        this.mStudentRepository = mStudentRepository;
    }

    public List<StudentClass> getStudents() {

        return mStudentRepository.findAll();

    }

    public void AddNewStudent(StudentClass newStudent) {

        Optional<StudentClass>mStudentEmail = mStudentRepository.
                findStudentClassByEmail(newStudent.getEmail());

        if (mStudentEmail.isPresent()) {

            throw new IllegalStateException("Email is taken");
        }
        mStudentRepository.save(newStudent);
    }


    public void RemoveStudent(Long studentId) {

        boolean exist = mStudentRepository.existsById(studentId);

        if (!exist) {

            throw new IllegalStateException(
                    "Student with ID " + studentId + " does Not exist"
            );
        }
        mStudentRepository.deleteById(studentId);
    }


    @Transactional
    public void UpdateStudentData(Long studentId, String name, String email) {

        StudentClass student = mStudentRepository.findById(studentId).
                orElseThrow(()->new IllegalStateException(
                "Student with ID " + studentId + " does Not exist"
        ));

        if (name != null && name.length() > 0) {

            student.setName(name);
        }

        if (email != null && email.length() > 0) {

            Optional<StudentClass> optionalStudentClass = mStudentRepository.findStudentClassByEmail(email);

            if (optionalStudentClass.isPresent()) {

                throw new IllegalStateException("Email taken");
            }

            student.setEmail(email);
        }

    }
}
