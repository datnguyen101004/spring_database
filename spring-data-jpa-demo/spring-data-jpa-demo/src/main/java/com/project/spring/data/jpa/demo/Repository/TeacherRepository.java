package com.project.spring.data.jpa.demo.Repository;

import com.project.spring.data.jpa.demo.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
