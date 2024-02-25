package com.project.spring.data.jpa.demo.Repository;

import com.project.spring.data.jpa.demo.Entity.Course;
import com.project.spring.data.jpa.demo.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void createTeacherTest(){
        Course course1 = Course.builder()
                .title("jk")
                .credit(5)
                .build();
        Course course2 = Course.builder()
                .title("da")
                .credit(6)
                .build();


        Teacher teacher = Teacher.builder()
                .courseList(List.of(course1, course2))
                .firstName("A")
                .lastName("B")
                .build();
        teacherRepository.save(teacher);
    }
}