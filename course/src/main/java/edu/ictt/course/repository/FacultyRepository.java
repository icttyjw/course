package edu.ictt.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ictt.course.bean.FacultyInfo;

public interface FacultyRepository extends JpaRepository<FacultyInfo, Integer>{

}
