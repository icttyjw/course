package edu.ictt.course.core.excel;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import edu.ictt.course.ApplicationContextProvider;
import edu.ictt.course.bean.Course;
import edu.ictt.course.bean.CourseInfo;
import edu.ictt.course.bean.FacultyInfo;
import edu.ictt.course.bean.ImportInfo;
import edu.ictt.course.bean.SchoolInfo;
import edu.ictt.course.bean.StudentInfo;
import edu.ictt.course.bean.TeacherInfo;
import edu.ictt.course.block.record.GradeInfo;
import edu.ictt.course.block.record.GradeRecord;
import edu.ictt.course.block.record.Record;
import edu.ictt.course.common.FastJsonUtil;
import edu.ictt.course.common.PairKey;
import edu.ictt.course.common.SHA256;
import edu.ictt.course.common.algorithm.ECDSAAlgorithm;
import edu.ictt.course.core.event.SendRecordEvent;
import edu.ictt.course.service.CourseService;
import edu.ictt.course.service.FacultyService;
import edu.ictt.course.service.SchoolService;
import edu.ictt.course.service.StudentService;
import edu.ictt.course.service.TeacherService;
import edu.ictt.course.socket.body.RecordBody;
@Component
public class ExcelListener extends AnalysisEventListener {

    //自定义用于暂时存储data。
    //可以通过实例获取该值
    private List<Object> datas = new ArrayList<Object>();
    private ConcurrentHashMap<Integer, List<Object>> objectcollect=new ConcurrentHashMap<Integer, List<Object>>();
    //private ConcurrentHashMap<String, Integer> courseid=new ConcurrentHashMap<String, Integer>();
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

    /**
     * 通过 AnalysisContext 对象还可以获取当前 sheet，当前行等数据
     */
    @Override
    public void invoke(Object object, AnalysisContext context) {
        //数据存储到list，供批量处理，或后续自己业务逻辑处理。
    	//System.out.println("当前行："+context.getCurrentRowNum());
        //System.out.println(object);
        System.out.println("当前sheet"+context.getCurrentSheet().getSheetNo()+ " 当前行：" + context.getCurrentRowNum()
        + " data:" + object.toString());
        /*
         * 需要校验读取的格式是否符合需要
         */
        List<Object> cs=new ArrayList<Object>();;
        if(context.getCurrentRowNum()==1)
        {
        	cs=new ArrayList<Object>();
        	
        }else
        	cs=objectcollect.get(1);
        cs.add(object);
        objectcollect.put(1, cs);
        //datas.add(object);
        //根据自己业务做处理
        //doSomething(object);
    }

    private void doSomething(Object object) {
    	//RecordBody recordBody=new R
    	//ApplicationContextProvider.publishEvent(new SendRecordEvent(source));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    	int count = datas.size();
    	/*
    	 * 需要通过上传老师的信息获得相应的课程及学院学校的信息，同时合成hash信息
    	 */
    	List<Object> cs=objectcollect.get(1);
    	Course course=courseService.findById(1);
    	CourseInfo courseInfo=new CourseInfo(course);
    	SchoolInfo school=schoolService.findById(course.getSchoolId());
    	FacultyInfo faculty=facultyService.findById(course.getFacultyId());
    	TeacherInfo teacher=teacherService.findById(course.getTeacherId());
    	TeacherInfo[] tl=new TeacherInfo[3];
    	tl[0]=teacher;
    	
    	PairKey tpairkey=teacher.getTeacherPairKey();
    	PairKey fpairkey=faculty.getFacultyPairKey();
    	String sc=FastJsonUtil.toJSONString(school);
    	String fa=FastJsonUtil.toJSONString(faculty);
    	String courshash=SHA256.sha256(school.getSchoolName()+faculty.getFacultyName()+teacher.getTeacherName()+course.getCourseName());
    	for(Object o:cs){
    		/*
    		 * 每条记录需要读取学生信息
    		 */
    		ImportInfo ii=(ImportInfo) o;
    		StudentInfo str=studentService.queryStuById(ii.getStuid());
    		GradeInfo gi=new GradeInfo(courseInfo, tl, str, ii.getScore());
    		String gr=FastJsonUtil.toJSONString(gi);
    		GradeRecord r=new GradeRecord(school, faculty, gi, null, null, System.currentTimeMillis());
    		try{
    			String strsign=sc+fa+gi+r.getRecordTimeStamp();
    			String tsign=ECDSAAlgorithm.sign(tpairkey.getPrivateKey(), strsign);
    			r.setTeacherSign(tsign);
    			
    			strsign=sc+fa+gi+r.getRecordTimeStamp()+tsign;
    			String fsign=ECDSAAlgorithm.sign(fpairkey.getPrivateKey(), strsign);
    			r.setFalSign(fsign);
    			ApplicationContextProvider.publishEvent(new SendRecordEvent(new RecordBody(r, courshash, count)));
    		}catch(UnsupportedEncodingException e){
    			e.printStackTrace();
    		}
    		//ApplicationContextProvider.publishEvent(new SendRecordEvent(new RecordBody(r, null, count)));
    	}
        /*
            datas.clear();
            解析结束销毁不用的资源
         */
    }

    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }
}
