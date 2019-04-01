package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.TeacherInfo;
import edu.ictt.course.repository.TeacherRepository;

@Service
public class TeacherService {

	@Resource
	private TeacherRepository teacherRepository;
	
	public TeacherInfo findById(int id){
		return teacherRepository.findOne(id);
	}
	public void save(TeacherInfo teacherInfo){
		teacherRepository.save(teacherInfo);
	}
}
