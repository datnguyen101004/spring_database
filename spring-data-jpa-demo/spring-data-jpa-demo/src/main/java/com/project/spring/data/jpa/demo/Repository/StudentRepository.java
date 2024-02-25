package com.project.spring.data.jpa.demo.Repository;

import com.project.spring.data.jpa.demo.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String firstName);

    List<Student> findByGuardianName(String guardianName);

    @Query(
            value = "SELECT * FROM tbl_hocsinh t WHERE t.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailId(String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_hocsinh set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
