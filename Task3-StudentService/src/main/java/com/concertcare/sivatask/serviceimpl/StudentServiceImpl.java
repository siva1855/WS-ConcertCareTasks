package com.concertcare.sivatask.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concertcare.sivatask.model.Student;
import com.concertcare.sivatask.repository.StudentRepository;
import com.concertcare.sivatask.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Integer saveStudent(Student student) {
		return studentRepository.save(student).getStudentId();
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> getOneStudent(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	@Override
	public boolean isExist(Integer id) {
		return studentRepository.existsById(id);
	}

}
