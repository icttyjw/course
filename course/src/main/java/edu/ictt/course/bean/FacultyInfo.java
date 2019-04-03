package edu.ictt.course.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.ictt.course.common.PairKey;

/**
 * @Author:zoe
 * @Description:
 * @Date:
 *
 */
public class FacultyInfo {

    //学院id
    private  int facultyId;

    //学院名称
    private  String facultyName;

    //学院特殊属性
    private String facultyPro;

    //学院密钥对
    private String pubKey;

    public FacultyInfo(){}

    public FacultyInfo(int facultyId, String facultyName, String facultyPro,String pubKey){
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPro = facultyPro;
        this.pubKey = pubKey;
    }
    
    public FacultyInfo(Faculty faculty){
    	this.facultyId=faculty.getFacultyId();
    	this.facultyName=faculty.getFacultyName();
    	this.facultyPro=faculty.getFacultyPro();
    	this.pubKey=faculty.getPubKey();
    }

    public int getFacultyId() {

        return facultyId;
    }

    public void setFacultyId(int facultyId) {

        this.facultyId = facultyId;
    }

    public String getFacultyName() {

        return facultyName;
    }

    public void setFacultyName(String facultyName) {

        this.facultyName = facultyName;
    }

    public String getFacultyPro() {

        return facultyPro;
    }

    public void setFacultyPro(String facultyPro) {

        this.facultyPro = facultyPro;
    }

    public String getPubKey() {
        return pubKey;
    }

    public void setPubKey(String pubKey) {
        this.pubKey = pubKey;
    }

    @Override
    public String toString() {
        return "FacultyInfo{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyPro='" + facultyPro + '\'' +
                ", pubKey=" + pubKey +
                '}';
    }
}
