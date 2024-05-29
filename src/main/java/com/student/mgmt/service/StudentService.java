package com.student.mgmt.service;

import java.util.List;

import com.student.mgmt.entity.Student;
import com.student.mgmt.model.StudentDto;


public interface StudentService {
	List<Student> getAllStudents();
	StudentDto saveStudent(StudentDto studentDto);
	StudentDto getStudentById(int id);
	StudentDto updateStudent(StudentDto student);
	void deleteById(int id);
}
