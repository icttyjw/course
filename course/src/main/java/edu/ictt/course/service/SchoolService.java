package edu.ictt.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.ictt.course.bean.School;
import edu.ictt.course.bean.SchoolInfo;
import edu.ictt.course.repository.SchoolRepository;

@Service
public class SchoolService {

	@Resource
	private SchoolRepository schoolRepository;
	
	public School findById(int id){
		return schoolRepository.findOne(id);
	}
	public void save(School school){
		schoolRepository.save(school);
	}
}
