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

public class StudentInfo {

	

    private int studentId;

    //学生姓名
    private String studentName;

    //学生属性
    private String studentPro;
    
    /**
     * 专业
     */
    private MajorInfo majorInfo;
    
    /**
     * 性别
     */
    private char studentSex;
    
    /**
     * 学制
     */
    private String schoolSystem;
    
    /**
     * 学历类别
     */
    private String degreeLevel;
    
    /**
     * 学习形式（普通全日制）
     */
    private String learnType;
    
    /**
     * 入学日期
     */
    private String joinDate;
    
    /**
     * 毕业日期
     */
    private String gradDate;


    public StudentInfo(){};

    public StudentInfo(Student student){
    	this.studentId=student.getStudentId();
    	this.studentName=student.getStudentName();
    	this.studentPro=student.getStudentPro();
    	this.studentSex=student.getStudentSex();
    }
    
    public StudentInfo(int studentId, String studentName, String studentPro){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentPro = studentPro;
    }
    
    public StudentInfo(int studentId, String studentName, char studentSex, String schoolSystem, String degreeLevel,
			String learnType, String joinDate, String gradDate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.schoolSystem = schoolSystem;
		this.degreeLevel = degreeLevel;
		this.learnType = learnType;
		this.joinDate = joinDate;
		this.gradDate = gradDate;
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

    public MajorInfo getMajorInfo() {
		return majorInfo;
	}

	public char getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(char studentSex) {
		this.studentSex = studentSex;
	}

	public String getSchoolSystem() {
		return schoolSystem;
	}

	public String getDegreeLevel() {
		return degreeLevel;
	}

	public String getLearnType() {
		return learnType;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public String getGradDate() {
		return gradDate;
	}

	public void setMajorInfo(MajorInfo majorInfo) {
		this.majorInfo = majorInfo;
	}

	public void setSchoolSystem(String schoolSystem) {
		this.schoolSystem = schoolSystem;
	}

	public void setDegreeLevel(String degreeLevel) {
		this.degreeLevel = degreeLevel;
	}

	public void setLearnType(String learnType) {
		this.learnType = learnType;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public void setGradDate(String gradDate) {
		this.gradDate = gradDate;
	}

	@Override
	public String toString() {
		return "StudentInfo [studentId=" + studentId + ", studentName=" + studentName + ", studentPro=" + studentPro
				+ ", majorInfo=" + majorInfo + ", studentSex=" + studentSex + ", schoolSystem=" + schoolSystem
				+ ", degreeLevel=" + degreeLevel + ", learnType=" + learnType + ", joinDate=" + joinDate + ", gradDate="
				+ gradDate + "]";
	}


}
