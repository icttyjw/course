package edu.ictt.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ictt.course.bean.SchoolInfo;
@Repository
public interface SchoolRepository extends JpaRepository<SchoolInfo, Integer>{

}
