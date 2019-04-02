package edu.ictt.course;

import edu.ictt.course.App;
import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.FacultyInfo;
import edu.ictt.course.bean.ImportInfo;
import edu.ictt.course.bean.SchoolInfo;
import edu.ictt.course.bean.StudentInfo;
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
import java.io.InputStream;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
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
		 InputStream inputStream = new FileInputStream(new File("recordf.xlsx"));
		 ExcelReader excelReader=new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, excelListener);
		 excelReader.read(new Sheet(1,1,ImportInfo.class));
	}
	@Test
	public void savefirst(){
		SchoolInfo schoolInfo=new SchoolInfo(1, "", new PairKey(), "");
		FacultyInfo facultyInfo=new FacultyInfo(1, "", "", new PairKey());
		TeacherInfo teacherInfo=new TeacherInfo(1, "", "", new PairKey());
		Course course=new Course(1, 1, 1, 1, "", 100, "", "");
		StudentInfo studentInfo=new StudentInfo(1, "", "");
		schoolService.save(schoolInfo);
		facultyService.save(facultyInfo);
		teacherService.save(teacherInfo);
		courseService.save(course);
		studentService.save(studentInfo);
	}
}
