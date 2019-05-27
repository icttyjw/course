package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Student {

	  //学生学号
		@Id
	    private int studentId;

	    //学生姓名
	    private String studentName;

	    //学生属性
	    private String studentPro;
	    
	    /**
	     * 专业
	     */
	    private int majorInfoId;
	    
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

		public int getStudentId() {
			return studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public String getStudentPro() {
			return studentPro;
		}

		public int getMajorInfoId() {
			return majorInfoId;
		}

		public char getStudentSex() {
			return studentSex;
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

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public void setStudentPro(String studentPro) {
			this.studentPro = studentPro;
		}

		public void setMajorInfoId(int majorInfoId) {
			this.majorInfoId = majorInfoId;
		}

		public void setStudentSex(char studentSex) {
			this.studentSex = studentSex;
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
	    
}
