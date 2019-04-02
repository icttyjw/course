package edu.ictt.course.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8087719624814456613L;

	@Id
	private int courseId;
	
	private int schoolId;
	private int facultyId;
	private int teacherId;
	
	private String courseName;
	
	 //课程学分
    private int courseCredit;

    //开课学期
    private String courseDate;

    //课程属性:必修学位，必修非学位等等
    private String coursePro;

    public Course(int courseId,int schoolId,int facultyId,int teacherId, String courseName, int courseCredit, String courseDate, String coursePro){
        this.courseId = courseId;
        this.schoolId=schoolId;
        this.facultyId=facultyId;
        this.teacherId=teacherId;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.courseDate = courseDate;
        this.coursePro = coursePro;
    }
	public int getCourseId() {
		return courseId;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public int getCourseCredit() {
		return courseCredit;
	}

	public String getCourseDate() {
		return courseDate;
	}

	public String getCoursePro() {
		return coursePro;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public void setCourseCredit(int courseCredit) {
		this.courseCredit = courseCredit;
	}

	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}

	public void setCoursePro(String coursePro) {
		this.coursePro = coursePro;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
    
}
