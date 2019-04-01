package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.StudentInfo;
import edu.ictt.course.repository.StudentRepository;

@Service
public class StudentService {

	@Resource
	private StudentRepository studentRepository;
	
	public StudentInfo queryStuById(int stuid){
		StudentInfo stu=studentRepository.findOne(stuid);
		return stu;
	}
	
	public void save(StudentInfo stu){
		studentRepository.save(stu);
	}
	
	
}
