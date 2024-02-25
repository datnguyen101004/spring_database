package com.project.spring.data.jpa.demo.Repository;

import com.project.spring.data.jpa.demo.Entity.Guardian;
import com.project.spring.data.jpa.demo.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student student = Student.builder()
                .emailId("datp@gmail.com")
                .firstName("Dat")
                .lastName("Pham")
                .build();
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("teach@gmail.com")
                .name("B")
                .mobile("1111111")
                .build();
        Student student = Student.builder()
                .emailId("datpht@gmail.com")
                .firstName("Dat")
                .lastName("Pham")
                .guardian(guardian)
                .build();
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("Da");
        System.out.println(studentList);
    }

    @Test
    public void printStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("A");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByEmailAddressTest(){
        Student student = studentRepository.getStudentByEmailId("dat@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentName(){
        studentRepository.updateStudentNameByEmailId("D", "dat@gmail.com");
    }

}