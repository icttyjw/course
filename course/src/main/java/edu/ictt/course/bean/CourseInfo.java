package edu.ictt.course.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 记录中课程信息类
 */


public class CourseInfo implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 631589829673002085L;

	//课程id
    private int courseId;

    //课程名
    private String courseName;

    //课程学分
    private int courseCredit;

    //开课学期
    private String courseDate;

    //课程属性:必修学位，必修非学位等等
    private String coursePro;


    public CourseInfo(){}

    public CourseInfo(int courseId, String courseName, int courseCredit, String courseDate, String coursePro){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCredit = courseCredit;
        this.courseDate = courseDate;
        this.coursePro = coursePro;
    }
    
    public CourseInfo(Course course){
    	this.courseId = course.getCourseId();
        this.courseName = course.getCourseName();
        this.courseCredit = course.getCourseCredit();
        this.courseDate = course.getCourseDate();
        this.coursePro = course.getCoursePro();
    }
    

	public int getCourseId() {

        return courseId;
    }

    public String getCourseName() {

        return courseName;
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

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseCredit=" + courseCredit +
                ", courseDate='" + courseDate + '\'' +
                ", coursePro='" + coursePro + '\'' +
                '}';
    }
}
