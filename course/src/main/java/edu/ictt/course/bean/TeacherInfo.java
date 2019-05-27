package edu.ictt.course.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.ictt.course.common.PairKey;

/**
 * 授课老师信息
 */
public class TeacherInfo implements Serializable{

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 9190493137357825337L;

	//任课教师工号
    private int teacherId;

    //任课教师姓名
    private String teacherName;

    //任课教师职称
    private String teacherPro;

    //任课教师密钥对
    private String teacherPubKey;
    /**
     * 任课教师性别
     */
    private char teacherSex;
    /**
     * 所属学院
     */
	private FacultyInfo facultyInfo;

    public TeacherInfo(){}

    public TeacherInfo(int teacherId, String teacherName, String teacherTitle, String pubKey){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPro = teacherTitle;
        this.teacherPubKey = pubKey;
    }
    public TeacherInfo(Teacher teacher){
    	this.teacherId=teacher.getTeacherId();
    	this.teacherName=teacher.getTeacherName();
    	this.teacherPro=teacher.getTeacherPro();
    	this.teacherSex=teacher.getTeacherSex();
    	this.teacherPubKey=teacher.getPubKey();
    }
    public TeacherInfo(FacultyInfo facultyInfo, int teacherId, String teacherName, char teacherSex, String teacherPro,
			String teacherPubKey) {
		super();
		this.facultyInfo = facultyInfo;
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teacherPro = teacherPro;
		this.teacherPubKey = teacherPubKey;
	}

	public int getTeacherId() {

        return teacherId;
    }

    public String getTeacherName()
    {

        return teacherName;
    }





    public String getTeacherPro() {
		return teacherPro;
	}

	public FacultyInfo getFacultyInfo() {
		return facultyInfo;
	}

	public void setTeacherPro(String teacherPro) {
		this.teacherPro = teacherPro;
	}

	public void setFacultyInfo(FacultyInfo facultyInfo) {
		this.facultyInfo = facultyInfo;
	}

	public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public char getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(char teacherSex) {
		this.teacherSex = teacherSex;
	}

	public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }



	public String getTeacherPubKey() {
		return teacherPubKey;
	}

	public void setTeacherPubKey(String teacherPubKey) {
		this.teacherPubKey = teacherPubKey;
	}
}
