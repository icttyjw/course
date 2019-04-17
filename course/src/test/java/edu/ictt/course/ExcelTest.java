package edu.ictt.course;

import edu.ictt.course.App;
import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.Faculty;
import edu.ictt.course.bean.FacultyInfo;
import edu.ictt.course.bean.ImportInfo;
import edu.ictt.course.bean.School;
import edu.ictt.course.bean.SchoolInfo;
import edu.ictt.course.bean.StudentInfo;
import edu.ictt.course.bean.Teacher;
import edu.ictt.course.bean.TeacherInfo;
import edu.ictt.course.common.PairKey;
import edu.ictt.course.core.excel.ExcelListener;
import edu.ictt.course.service.CourseService;
import edu.ictt.course.service.FacultyService;
import edu.ictt.course.service.SchoolService;
import edu.ictt.course.service.StudentService;
import edu.ictt.course.service.TeacherService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class ExcelTest {

	 @Resource
	 private ExcelListener excelListener;
	 @Resource
	 private CourseService courseService;
	 @Resource
	 private StudentService studentService;
	 @Resource
	 private FacultyService facultyService;
	 @Resource
	 private SchoolService schoolService;
	 @Resource
	 private TeacherService teacherService;
	
	@Test
	public void read() throws FileNotFoundException{
		 InputStream inputStream = new FileInputStream(new File("test.xlsx"));
		 ExcelReader excelReader=new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, excelListener);
		 excelReader.read(new Sheet(1,0,ImportInfo.class));
	}
	@Test
	public void jsonread()throws FileNotFoundException{
		 InputStream inputStream = new FileInputStream(new File("test.xlsx"));
		 ExcelReader excelReader=new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, excelListener);
		 excelReader.read(new Sheet(1,1,ImportInfo.class));
	}
	/*
	public void savefirst(){
		System.out.println(1);
		PairKey skey=new PairKey();
		PairKey fkey=new PairKey();
		PairKey tkey=new PairKey();
		School school=new School(1, "", "",skey.getPublicKey(), skey.getPrivateKey());
		Faculty faculty=new Faculty(1, "", "", fkey.getPublicKey(),fkey.getPrivateKey());
		Teacher teacher=new Teacher(1, "", "", tkey.getPublicKey(),tkey.getPrivateKey());
		Course course=new Course(1, 1, 1, 1, "", 100, "", "");
		StudentInfo studentInfo=new StudentInfo(1, "", "");
		schoolService.save(school);
		facultyService.save(faculty);
		teacherService.save(teacher);
		courseService.save(course);
		studentService.save(studentInfo);
	}*/
	 @Test
	    public void testExcel2003NoModel() throws FileNotFoundException {
	        InputStream inputStream = new FileInputStream(new File("test.xlsx"));
	        try {
	            // 解析每行结果在listener中处理
	            ExcelListener listener = new ExcelListener();
	            //ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, ImportInfo.class, listener);
	           ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new AnalysisEventListener() {
	                @Override
	                public void invoke(Object o, AnalysisContext analysisContext) {
	                  System.out.println("当前sheet"+analysisContext.getCurrentSheet().getSheetNo()+ " 当前行：" + analysisContext.getCurrentRowNum()
	                          + " data:" + o.toString());
	                  ImportInfo ii=(ImportInfo)o;
	                  //StudentInfo stu=new StudentInfo(ii.getStuid(), ii.getName(), "本科");
	                  //studentService.save(stu);
	                  //System.out.println(ii.getScore());
	                }
	         
	                @Override
	                public void doAfterAllAnalysed(AnalysisContext analysisContext) {
	         
	                }
	              });
	            excelReader.read(new Sheet(1, 0, ImportInfo.class));
	        } catch (Exception e) {
	        	 System.out.println(e);
	        } finally {
	            try {
	                inputStream.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	 }
}
