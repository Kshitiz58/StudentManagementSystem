package com.student.mgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.mgmt.entity.Student;




public interface StudentRepository extends JpaRepository<Student, Integer> {

}
