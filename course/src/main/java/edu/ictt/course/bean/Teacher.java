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

    //任课教师姓名
    private String teacherName;

    //任课教师职称
    private String teacherTitle;

    //任课教师密钥对
    private String pubKey;
    private String priKey;
    public Teacher(){};
    
    public Teacher(int teacherId,String teacherName,String teacherTitle,String pubKey,String priKey){
    	this.teacherId=teacherId;
    	this.teacherName=teacherName;
    	this.teacherTitle=teacherTitle;
    	this.pubKey=pubKey;
    	this.priKey=priKey;
    }
    
	public int getTeacherId() {
		return teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public String getTeacherTitle() {
		return teacherTitle;
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
	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}
	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}
	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}
    
}
