package edu.ictt.course.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.CourseInfo;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	@Query(value="SELECT * FROM course WHERE course_name=?1",nativeQuery=true)
	public Course queryByName(@Param("course_name") String name);
}
