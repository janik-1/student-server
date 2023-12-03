package fr.efrei.studentserver.service;


import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    public final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(Integer id) {
        Optional<Student> Student = studentRepository.findById(id);
        return Student.orElse(null);
    }

}