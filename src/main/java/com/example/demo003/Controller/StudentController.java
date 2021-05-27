package com.example.demo003.Controller;

import com.example.demo003.Service.StudentService;
import com.example.demo003.Student.StudentClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService mstudentService;

    @Autowired
    public StudentController(StudentService mstudentService) {
        this.mstudentService = mstudentService;
    }

    @GetMapping
    public List<StudentClass> getStudents() {

        return mstudentService.getStudents();

    }

    @PostMapping
    public void RegisterNewStudent(@RequestBody StudentClass mstudentClass) {

        mstudentService.AddNewStudent(mstudentClass);
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId")Long studentId) {

        mstudentService.RemoveStudent(studentId);
    }


    @PutMapping(path = "{studentId}")
    public void UpdateStudent(
            @PathVariable("studentId")Long studentId,
            @RequestParam(required = true)String name,
            @RequestParam(required = true)String email) {

        mstudentService.UpdateStudentData(studentId,name,email);

    }



}
