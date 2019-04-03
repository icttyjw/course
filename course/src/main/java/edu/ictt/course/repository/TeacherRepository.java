package edu.ictt.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ictt.course.bean.Teacher;
import edu.ictt.course.bean.TeacherInfo;
@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Integer>{

}
