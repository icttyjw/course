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
@Entity
@Table
public class FacultyInfo {

    //学院id
	@Id
    private  int facultyId;

    //学院名称
    private  String facultyName;

    //学院特殊属性
    private String facultyPro;

    //学院密钥对
    private PairKey facultyPairKey;

    public FacultyInfo(){}

    public FacultyInfo(int facultyId, String facultyName, String facultyPro,PairKey facultyPairKey){
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPro = facultyPro;
        this.facultyPairKey = facultyPairKey;
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

    public PairKey getFacultyPairKey() {
        return facultyPairKey;
    }

    public void setFacultyPairKey(PairKey facultyPairKey) {
        this.facultyPairKey = facultyPairKey;
    }

    @Override
    public String toString() {
        return "FacultyInfo{" +
                "facultyId=" + facultyId +
                ", facultyName='" + facultyName + '\'' +
                ", facultyPro='" + facultyPro + '\'' +
                ", facultyPairKey=" + facultyPairKey +
                '}';
    }
}
