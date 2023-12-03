package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.service.StudentService;
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

    @GetMapping("/student")
    public List<Student> getAllItem() {
        return studentService.findAll();
    }

    @GetMapping("/student/{id}")
    public Student getItem(@PathVariable String id) {
        Student student1 = new Student();
        student1.setName("Pierre");
        return student1;
    }
}