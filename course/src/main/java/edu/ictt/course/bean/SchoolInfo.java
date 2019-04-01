package edu.ictt.course.bean;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import edu.ictt.course.common.PairKey;

/**
 * 记录中学校信息类
 */

@Entity
@Table
public class SchoolInfo implements Serializable{

	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2082365746841370197L;

	//学校编号
	@Id
    private int schoolId;

    //学校名
    private String schoolName;

    //学校密钥对
    private PairKey schoolPairKey;

    //学校特殊属性:比如一本，二本那些，这个属性可能包含多个内容
    //private List<String> schoolPro = new ArrayList<>();
    private String schoolPro;

    public SchoolInfo(){}

  /*  public SchoolInfo(int schoolId, String schoolName, PairKey schoolPairKey, List<String> schoolPro){
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolPairKey = schoolPairKey;
        this.schoolPro = schoolPro;
    }*/
    
    public SchoolInfo(int schoolId, String schoolName, PairKey schoolPairKey, String schoolPro){
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolPairKey = schoolPairKey;
        this.schoolPro = schoolPro;
    }
    
   

	public String getSchoolPro() {
		return schoolPro;
	}

	
	public void setSchoolPro(String schoolPro) {
		this.schoolPro = schoolPro;
	}

	public int getSchoolId() {

        return schoolId;
    }

    public String getSchoolName() {

        return schoolName;
    }

    public PairKey getSchoolPairKey() {
        return schoolPairKey;
    }
    /*
    public List<String> getSchoolPro() {

        return schoolPro;
    }

    public void setSchoolPro(ArrayList<String> schoolPro) {

        this.schoolPro = schoolPro;
    }
     public void setSchoolPro(List<String> schoolPro) {
        this.schoolPro = schoolPro;
    }
    */

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public void setSchoolPairKey(PairKey schoolPairKey) {
        this.schoolPairKey = schoolPairKey;
    }

   

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "schoolId=" + schoolId +
                ", schoolName='" + schoolName + '\'' +
                ", schoolPairKey=" + schoolPairKey +
                ", schoolPro=" + schoolPro +
                '}';
    }
}