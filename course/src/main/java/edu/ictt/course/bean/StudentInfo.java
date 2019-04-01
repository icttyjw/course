package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author:zoe
 * @Description:
 * @Date:
 *
 */
@Entity
@Table
public class StudentInfo {

	
	
    //学生学号
	@Id
    private int studentId;

    //学生姓名
    private String studentName;

    //学生属性
    private String studentPro;

    public StudentInfo(){};

    public StudentInfo(int studentId, String studentName, String studentPro){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPro = studentPro;
    }
    

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPro() {
        return studentPro;
    }

    public void setStudentPro(String studentPro) {
        this.studentPro = studentPro;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentPro='" + studentPro + '\'' +
                '}';
    }
}
