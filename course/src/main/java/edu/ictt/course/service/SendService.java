package edu.ictt.course.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.CourseInfo;
import edu.ictt.course.bean.Faculty;
import edu.ictt.course.bean.FacultyInfo;
import edu.ictt.course.bean.ImportInfo;
import edu.ictt.course.bean.NewGradeInfo;
import edu.ictt.course.bean.School;
import edu.ictt.course.bean.SchoolInfo;
import edu.ictt.course.bean.Student;
import edu.ictt.course.bean.StudentInfo;
import edu.ictt.course.bean.Teacher;
import edu.ictt.course.bean.TeacherInfo;
import edu.ictt.course.block.record.GradeInfo;
import edu.ictt.course.block.record.GradeRecord;
import edu.ictt.course.block.record.NewRecord;
import edu.ictt.course.common.FastJsonUtil;
import edu.ictt.course.common.SHA256;
import edu.ictt.course.common.SignUtil;
import edu.ictt.course.common.algorithm.ECDSAAlgorithm;
import edu.ictt.course.core.controller.Message;
import edu.ictt.course.core.event.SendRecordEvent;
import edu.ictt.course.socket.body.RecordBody;
import edu.ictt.course.socket.client.PacketSender;

@Service
public class SendService {

	@Resource
	private CourseService courseService;
	@Resource
	private FacultyService facultyService;
	@Resource
	private SchoolService schoolService;
	@Resource
	private StudentService studentService;
	@Resource
	private TeacherService teacherService;
	@Resource
	private PacketSender packetSender;
	
	Logger logger=LoggerFactory.getLogger(getClass());
	
	public void send(String filename,String coursename){
    	Course course=courseService.findByName(coursename);
    	CourseInfo courseInfo=new CourseInfo(course);
    	School school=schoolService.findById(course.getSchoolId());
    	Faculty faculty=facultyService.findById(course.getFacultyId());
    	Teacher teacher=teacherService.findById(course.getTeacherId());
    	SchoolInfo sinfo=new SchoolInfo(school);
    	FacultyInfo finfo=new FacultyInfo(faculty);
    	TeacherInfo[] tl=new TeacherInfo[3];
    	TeacherInfo tinfo=new TeacherInfo(teacher);
    	tl[0]=tinfo;
    	String teaprikey=teacher.getPriKey();
    	//String teapubkey=teacher.getPubKey();
    	String facprikey=faculty.getPriKey();
    	//String facpubkey=faculty.getPubKey();
    	String sc=FastJsonUtil.toJSONString(sinfo);
    	String fa=FastJsonUtil.toJSONString(finfo);
    	String courshash=SHA256.sha256(school.getSchoolName()+faculty.getFacultyName()+teacher.getTeacherName()+course.getCourseName());
		 try {
			 	
	        	File path = new File(ResourceUtils.getURL("classpath:").getPath());
	        	 if(!path.getParentFile().exists()){
	                 path.getParentFile().mkdirs();//创建父级文件路径
	                 path.createNewFile();//创建文件
	                 System.out.println(path.exists());
	             }
	    		System.out.println("path:"+path.getAbsolutePath());

	    		//如果上传目录为/static/images/upload/，则可以如下获取：
	    		File upload = new File(path.getAbsolutePath(),"static/upload/"+filename);
	    		if(!upload.getParentFile().exists()){ 
	    			upload.getParentFile().mkdirs();
	    			upload.createNewFile();
	    		}
	    		InputStream inputStream = new FileInputStream(upload);
	    		List<Object> datas = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
	    		int count=datas.size();
	    		for(Object data:datas){
	    			ImportInfo ii=(ImportInfo) data;
	        		Student str=studentService.queryStuById(ii.getStuid());
	        		StudentInfo strinfo=new StudentInfo(str);
	        		GradeInfo gi=new GradeInfo(courseInfo, tl, strinfo, ii.getScore());
	        		String gr=FastJsonUtil.toJSONString(gi);
	        		GradeRecord r=new GradeRecord(sinfo, finfo, gi, null, null, System.currentTimeMillis());
	        		try{
	        			String strsign=sc+fa+gi+r.getRecordTimeStamp();
	        			String tsign=ECDSAAlgorithm.sign(teaprikey, strsign);
	        			r.setTeacherSign(tsign);
	        			
	        			strsign=sc+fa+gi+r.getRecordTimeStamp()+tsign;
	        			String fsign=ECDSAAlgorithm.sign(facprikey, strsign);
	        			r.setFacultySign(fsign);
	        			System.out.println("record hash:" +SHA256.sha256(FastJsonUtil.toJSONString(r)));
	        			ApplicationContextProvider.publishEvent(new SendRecordEvent(new RecordBody(r, courshash, count)));
	        		}catch(UnsupportedEncodingException e){
	        			e.printStackTrace();
	        		}
	    		
	    		}
	            inputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}
	public void send(Path filename,String coursename){
    	Course course=courseService.findByName(coursename);
    	CourseInfo courseInfo=new CourseInfo(course);
    	School school=schoolService.findById(course.getSchoolId());
    	Faculty faculty=facultyService.findById(course.getFacultyId());
    	Teacher teacher=teacherService.findById(course.getTeacherId());
    	SchoolInfo sinfo=new SchoolInfo(school);
    	FacultyInfo finfo=new FacultyInfo(faculty);
    	TeacherInfo[] tl=new TeacherInfo[3];
    	TeacherInfo tinfo=new TeacherInfo(teacher);
    	tl[0]=tinfo;
    	String teaprikey=teacher.getPriKey();
    	//String teapubkey=teacher.getPubKey();
    	String facprikey=faculty.getPriKey();
    	//String facpubkey=faculty.getPubKey();
    	String sc=FastJsonUtil.toJSONString(sinfo);
    	String fa=FastJsonUtil.toJSONString(finfo);
    	String courshash=SHA256.sha256(school.getSchoolName()+faculty.getFacultyName()+teacher.getTeacherName()+course.getCourseName());
		 try {
			 	File file=filename.toFile();
	    		InputStream inputStream = new FileInputStream(file);
	    		List<Object> datas = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
	    		int count=datas.size();
	    		for(Object data:datas){
	    			logger.info(""+data.getClass());
	    			logger.info(""+data);
	    			ArrayList<String> li=(ArrayList<String>)data;
	    			ImportInfo ii=new ImportInfo();
	    			ii.setStuid(Integer.parseInt(li.get(0)));
	    			ii.setName(li.get(1));
	    			ii.setScore(Double.valueOf(li.get(2)));
	        		Student str=studentService.queryStuById(ii.getStuid());
	        		StudentInfo strinfo=new StudentInfo(str);
	        		GradeInfo gi=new GradeInfo(courseInfo, tl, strinfo, ii.getScore());
	        		String gr=FastJsonUtil.toJSONString(gi);
	        		GradeRecord r=new GradeRecord(sinfo, finfo, gi, null, null, System.currentTimeMillis());
	        		try{
	        			String strsign=sc+fa+gi+r.getRecordTimeStamp();
	        			String tsign=ECDSAAlgorithm.sign(teaprikey, strsign);
	        			r.setTeacherSign(tsign);
	        			
	        			strsign=sc+fa+gi+r.getRecordTimeStamp()+tsign;
	        			String fsign=ECDSAAlgorithm.sign(facprikey, strsign);
	        			r.setFacultySign(fsign);
	        			System.out.println("record hash:" +SHA256.sha256(FastJsonUtil.toJSONString(r)));
	        			ApplicationContextProvider.publishEvent(new SendRecordEvent(new RecordBody(r, courshash, count)));
	        		}catch(UnsupportedEncodingException e){
	        			e.printStackTrace();
	        		}
	    		
	    		}
	            inputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}
	public void sendNew(Path filename,String coursename){
    	Course course=courseService.findByName(coursename);
    	CourseInfo courseInfo=new CourseInfo(course);
    	School school=schoolService.findById(course.getSchoolId());
    	Faculty faculty=facultyService.findById(course.getFacultyId());
    	Teacher teacher=teacherService.findById(course.getTeacherId());
    	SchoolInfo sinfo=new SchoolInfo(school);
    	FacultyInfo finfo=new FacultyInfo(faculty);
    	TeacherInfo[] tl=new TeacherInfo[3];
    	TeacherInfo tinfo=new TeacherInfo(teacher);
    	tinfo.setFacultyInfo(finfo);
    	tl[0]=tinfo;
    	String teaprikey=teacher.getPriKey();
    	//String teapubkey=teacher.getPubKey();
    	String facprikey=faculty.getPriKey();
    	//String facpubkey=faculty.getPubKey();
    	String sc=FastJsonUtil.toJSONString(sinfo);
    	String fa=FastJsonUtil.toJSONString(finfo);
    	String courshash=SHA256.sha256(school.getSchoolName()+faculty.getFacultyName()+teacher.getTeacherName()+course.getCourseName());
		 try {
			 	File file=filename.toFile();
	    		InputStream inputStream = new FileInputStream(file);
	    		List<Object> datas = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
	    		int count=datas.size();
	    		for(Object data:datas){
	    			ImportInfo ii=(ImportInfo) data;
	        		Student str=studentService.queryStuById(ii.getStuid());
	        		NewGradeInfo newGradeInfo=new NewGradeInfo(sinfo, finfo.getFacultyId(), str.getMajorInfoId(), course.getCourseId(), teacher.getTeacherId(), 
	        				str.getStudentId(), ii.getScore(), facprikey, teaprikey);
	        		String gradesign=SignUtil.gradetsign(newGradeInfo, teaprikey);
	        		newGradeInfo.setTeacherSign(gradesign);
	        		NewRecord r=new NewRecord(1, newGradeInfo, null, null, System.currentTimeMillis(), null);
	        		String recordsign=SignUtil.recordfsign(r, facprikey);
	        		r.setSign(recordsign);
	        			ApplicationContextProvider.publishEvent(new SendRecordEvent(new RecordBody(r, courshash, count)));
	        
	    		
	    		}
	            inputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } 
	}
	
}
