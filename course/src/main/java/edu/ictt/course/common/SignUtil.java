package edu.ictt.course.common;

import java.io.UnsupportedEncodingException;

import edu.ictt.course.bean.NewGradeInfo;
import edu.ictt.course.block.record.NewRecord;
import edu.ictt.course.common.algorithm.ECDSAAlgorithm;

public class SignUtil {

	public static String gradetsign(NewGradeInfo gradeInfo,String tPriKey){
		String grade = FastJsonUtil.toJSONString(gradeInfo.getSchoolInfo()) + gradeInfo.getFaculthId()
		+ gradeInfo.getMajorId() + gradeInfo.getCourseId() + gradeInfo.getTeacherId()+gradeInfo.getStudentId()
		+ gradeInfo.getGrade();
		try {
			String sign = ECDSAAlgorithm.sign(tPriKey, grade);
			return sign;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String recordfsign(NewRecord record,String prikey){
		NewGradeInfo gradeInfo=record.getGradeInfo();
		String faculty = FastJsonUtil.toJSONString(gradeInfo);
		String signSring = record.getRecord_type() + faculty + record.getTimeStamp() + record.getComment();
		try {
			String sign = ECDSAAlgorithm.sign(prikey, signSring);
			return sign;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
