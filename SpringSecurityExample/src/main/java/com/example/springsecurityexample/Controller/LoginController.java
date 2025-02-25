package com.example.springsecurityexample.Controller;

import com.example.springsecurityexample.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    private List<Student> students=new ArrayList<Student>(List.of(
            new Student(1,"Shashank",44),
            new Student(2,"Sunita",46)
            ));

    @GetMapping("/students")
    public List<Student> getStudents() {

        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getScrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {

        students.add(student);
        return student;

    }





}
