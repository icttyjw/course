package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.ictt.course.common.PairKey;
@Entity
@Table
public class Teacher {

	@Id
    private int teacherId;

	private int facultyId;
	
    //任课教师姓名
    private String teacherName;

    //任课教师职称
    private String teacherPro;
    
    /**
     * 任课教师性别
     */
    private char teacherSex;


    //任课教师密钥对
    private String pubKey;
    private String priKey;
    public Teacher(){};
    
    public Teacher(int teacherId,String teacherName,String teacherTitle,String pubKey,String priKey){
    	this.teacherId=teacherId;
    	this.teacherName=teacherName;
    	this.teacherPro=teacherTitle;
    	this.pubKey=pubKey;
    	this.priKey=priKey;
    }
    
	public int getTeacherId() {
		return teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public String getPubKey() {
		return pubKey;
	}
	public String getPriKey() {
		return priKey;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}
	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public String getTeacherPro() {
		return teacherPro;
	}

	public char getTeacherSex() {
		return teacherSex;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public void setTeacherPro(String teacherPro) {
		this.teacherPro = teacherPro;
	}

	public void setTeacherSex(char teacherSex) {
		this.teacherSex = teacherSex;
	}
    
}
