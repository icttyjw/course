package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Faculty {

	@Id
	 private  int facultyId;

	    //学院名称
	    private  String facultyName;

	    //学院特殊属性
	    private String facultyPro;

	    //学院密钥对
	    private String pubKey;
	    private String priKey;

	    public Faculty(){};
	    
	    public Faculty(int facultyId,String facultyName,String facultyPro,String pubKey,String priKey){
	    	this.facultyId=facultyId;
	    	this.facultyName=facultyName;
	    	this.facultyPro=facultyPro;
	    	this.pubKey=pubKey;
	    	this.priKey=priKey;
	    }
	    
		public String getPriKey() {
			return priKey;
		}

		public void setPriKey(String priKey) {
			this.priKey = priKey;
		}

		public int getFacultyId() {
			return facultyId;
		}

		public String getFacultyName() {
			return facultyName;
		}

		public String getFacultyPro() {
			return facultyPro;
		}

		public String getPubKey() {
			return pubKey;
		}

		public void setFacultyId(int facultyId) {
			this.facultyId = facultyId;
		}

		public void setFacultyName(String facultyName) {
			this.facultyName = facultyName;
		}

		public void setFacultyPro(String facultyPro) {
			this.facultyPro = facultyPro;
		}

		public void setPubKey(String pubKey) {
			this.pubKey = pubKey;
		}
	    
}
