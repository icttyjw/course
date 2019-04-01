package edu.ictt.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ictt.course.bean.StudentInfo;
@Repository
public interface StudentRepository extends JpaRepository<StudentInfo, Integer>{

}
