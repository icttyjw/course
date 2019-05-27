package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.Student;
import edu.ictt.course.bean.StudentInfo;
import edu.ictt.course.repository.StudentRepository;

@Service
public class StudentService {

	@Resource
	private StudentRepository studentRepository;
	
	public Student queryStuById(int stuid){
		Student stu=studentRepository.findOne(stuid);
		return stu;
	}
	
	public void save(Student stu){
		studentRepository.save(stu);
	}
	
	
}
