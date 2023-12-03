package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRessource {
    public final StudentService studentService;

    public StudentRessource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {
        Student student = studentService.findById(Integer.valueOf(id));

        if (student != null) {
            return student;
        } else {
            return student; // Null student blank page
        }
    }
}