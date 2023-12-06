package fr.efrei.studentserver.web.rest;

import fr.efrei.studentserver.domain.Student;
import fr.efrei.studentserver.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties")

public class StudentRessourceIT {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    void createStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setName("Loic");
        studentRepository.save(student);

        List<Student> studentList = studentRepository.findAll();
        assertThat(studentList).hasSize(databaseSizeBeforeCreate + 1);
    }

    @Test
    @Transactional
    void GetStudent() throws Exception {
        int databaseSizeBeforeCreate = studentRepository.findAll().size();
        assertThat(databaseSizeBeforeCreate).isEqualTo(0);

        Student student = new Student();
        student.setName("Luc");
        studentRepository.save(student);
        Student StudentGet = studentRepository.findById(student.getId()).orElse(null);
        assertThat(StudentGet).isNotNull();
        assertThat(StudentGet.getId()).isEqualTo(student.getId());
        assertThat(StudentGet.getName()).isEqualTo(student.getName());
        assertThat(StudentGet.getAge()).isEqualTo(student.getAge());
    }

    @Test
    @Transactional
    void updateStudent() {
        Student student = new Student();
        student.setName("Luc2");
        studentRepository.save(student);
        student.setName("UpdatedName");
        studentRepository.save(student);  // This will perform an update
        Student updatedStudent = studentRepository.findById(student.getId()).orElse(null);
        assertThat(updatedStudent).isNotNull();
        assertThat(updatedStudent.getName()).isEqualTo("UpdatedName");
    }

    @Test
    @Transactional
    void deleteStudent() {
        Student student = new Student();
        student.setName("Luc3");
        studentRepository.save(student);
        studentRepository.deleteById(student.getId());
        Optional<Student> deletedStudentOptional = studentRepository.findById(student.getId());
        assertThat(deletedStudentOptional).isEmpty();
    }

    @Test
    void getAllStudents() {
        Student student1 = new Student();
        student1.setName("Luc");
        studentRepository.save(student1);

        Student student2 = new Student();
        student2.setName("John");
        studentRepository.save(student2);
        List<Student> allStudents = studentRepository.findAll();
        assertThat(allStudents).hasSize(2);
    }

}