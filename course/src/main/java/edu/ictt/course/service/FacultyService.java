package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.Faculty;
import edu.ictt.course.bean.FacultyInfo;
import edu.ictt.course.repository.FacultyRepository;

@Service
public class FacultyService {

	@Resource
	private FacultyRepository facultyRepository;
	
	public Faculty findById(int id){
		return facultyRepository.findOne(id);
	}
	
	public void save(Faculty faculty){
		facultyRepository.save(faculty);
	}
}
