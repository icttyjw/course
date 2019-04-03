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
    private String teacherTitle;

    //任课教师密钥对
    private String pubKey;

    public TeacherInfo(){}

    public TeacherInfo(int teacherId, String teacherName, String teacherTitle, String pubKey){
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherTitle = teacherTitle;
        this.pubKey = pubKey;
    }
    public TeacherInfo(Teacher teacher){
    	this.teacherId=teacher.getTeacherId();
    	this.teacherName=teacher.getTeacherName();
    	this.teacherTitle=teacher.getTeacherTitle();
    	this.pubKey=teacher.getPubKey();
    }
   

	public int getTeacherId() {

        return teacherId;
    }

    public String getTeacherName()
    {

        return teacherName;
    }

    public String getTeacherTitle() {

        return teacherTitle;
    }

    public String getPubKey() {
        return pubKey;
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


    @Override
    public String toString() {
        return "TeacherInfo{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherTitle='" + teacherTitle + '\'' +
                ", pubKey=" + pubKey +
                '}';
    }
}
