package edu.ictt.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.CourseInfo;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
