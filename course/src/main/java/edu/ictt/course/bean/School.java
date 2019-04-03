package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class School {

	@Id
    private int schoolId;

    //学校名
    private String schoolName;

    //学校密钥对
    private String pubKey;
    private String priKey;

    //学校特殊属性:比如一本，二本那些，这个属性可能包含多个内容
    //private List<String> schoolPro = new ArrayList<>();
    private String schoolPro;
    
    public School(){};

    public School(int schoolId,String schoolName,String schoolPro,String pubKey,String priKey){
    	this.schoolId=schoolId;
    	this.schoolName=schoolName;
    	this.schoolPro=schoolPro;
    	this.pubKey=pubKey;
    	this.priKey=priKey;
    }
    
	public int getSchoolId() {
		return schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public String getPubKey() {
		return pubKey;
	}

	public String getPriKey() {
		return priKey;
	}

	public String getSchoolPro() {
		return schoolPro;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setPubKey(String pubKey) {
		this.pubKey = pubKey;
	}

	public void setPriKey(String priKey) {
		this.priKey = priKey;
	}

	public void setSchoolPro(String schoolPro) {
		this.schoolPro = schoolPro;
	}
    
}
