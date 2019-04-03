package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.Teacher;
import edu.ictt.course.bean.TeacherInfo;
import edu.ictt.course.repository.TeacherRepository;

@Service
public class TeacherService {

	@Resource
	private TeacherRepository teacherRepository;
	
	public Teacher findById(int id){
		return teacherRepository.findOne(id);
	}
	public void save(Teacher teacher){
		teacherRepository.save(teacher);
	}
}
