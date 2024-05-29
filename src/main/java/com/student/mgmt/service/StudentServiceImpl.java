package com.student.mgmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.student.mgmt.entity.Student;
import com.student.mgmt.exception.ResourceNotFoundException;
import com.student.mgmt.model.StudentDto;
import com.student.mgmt.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	private final ModelMapper modelMapper;
	
	public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
		super();
		this.studentRepository = studentRepository;
		this.modelMapper = modelMapper;
	}

	public List<StudentDto> getAllStudents(){
		List<Student> students=this.studentRepository.findAll();
		List<StudentDto> studentDtos=this.studentRepository.findAll().stream().map(this::studentToDto).collect(Collectors.toList());

		return studentDtos;
	}

	@Override
	public StudentDto saveStudent(StudentDto studentDto) {
		Student student=this.dtoToStudent(studentDto);
		Student student1=this.studentRepository.save(student);
		return studentToDto(student1);
	}

	@Override
	public StudentDto getStudentById(int id) {
		Student student=this.studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Value with this ","id",id));
		
		return studentToDto(student);
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto) {
		Student student=this.dtoToStudent(studentDto);
		student.setEmail(studentDto.getEmail());
		student.setId(studentDto.getId());
		student.setEmail(studentDto.getEmail());
		student.setSchoolName(studentDto.getSchoolName());

		Student student1=this.studentRepository.save(student);
		
		return studentToDto(student1);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
		
	}

	public Student dtoToStudent(StudentDto studentDto){
		Student student=this.modelMapper.map(studentDto,Student.class);
		return student;
	}
	
	public StudentDto studentToDto(Student student){
		StudentDto studentDto=this.modelMapper.map(student,StudentDto.class);
		return studentDto;
	}
	
	
}
