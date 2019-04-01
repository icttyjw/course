package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.CourseInfo;
import edu.ictt.course.repository.CourseRepository;

@Service
public class CourseService {

	@Resource
	private CourseRepository courseRepository;
	
	public Course findById(int id){
		return courseRepository.findOne(id);
	}
	
	public void save(Course courseInfo){
		courseRepository.save(courseInfo);
	}
}
