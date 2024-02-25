package com.project.spring.data.jpa.demo.Repository;

import com.project.spring.data.jpa.demo.Entity.Course;
import com.project.spring.data.jpa.demo.Entity.Student;
import com.project.spring.data.jpa.demo.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findAllCourseTest(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
    }

    @Test
    public void findAllPage(){
        Pageable page = PageRequest.of(0,3,Sort.by("credit").descending());
        List<Course> courseList = courseRepository.findAll(page).getContent();
        System.out.println(courseList);
    }

    @Test
    public void findByTitleContainingTest(){
        Pageable pageable = PageRequest.of(0,2,Sort.by("credit").descending());
        List<Course> courseList = courseRepository.findByTitleContainingIgnoreCase("h", pageable).getContent();
        System.out.println(courseList);
    }

    @Test
    public void addStudentAndCourse(){
        Student student = Student.builder()
                .emailId("a@gmail.com")
                .firstName("h")
                .lastName("b")
                .build();

        Course course = Course.builder()
                .title("mapWithStudent")
                .credit(1)
                .studentList(List.of(student))
                .build();
        courseRepository.save(course);
    }

    @Test
    public void createCourseDependencyTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("m")
                .firstName("n")
                .build();
        Course course = Course.builder()
                .credit(1)
                .title("createCourseDependencyTeacher")
                //.teacher(teacher)
                .build();
        courseRepository.save(course);
    }
}