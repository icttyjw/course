package jsontest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.google.gson.Gson;

import edu.ictt.course.block.BlockBody;
import edu.ictt.course.block.record.GradeRecord;
import edu.ictt.course.block.record.Record;
import edu.ictt.course.common.FastJsonUtil;

public class Autotype {

	@Test
	public void auto(){
		 ParserConfig parserConfig = new ParserConfig() {
	            @Override
	            public ObjectDeserializer getDeserializer(Type type) {
	                if (type == Record.class) {
	                	try {
							System.out.println(ReflectionUtil.getClass(type));
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                    return super.getDeserializer(GradeRecord.class);
	                }
	                return super.getDeserializer(type);
	            }
	        };
		GradeRecord r1=GenerateRecord.geneGRecord();
		GradeRecord r2=GenerateRecord.geneGRecord();
		List<GradeRecord> lr=new ArrayList<>();
		lr.add(r1);
		lr.add(r2);
		BlockBody blockBody=new BlockBody(lr, null);
		String bbjs=JSON.toJSONString(blockBody);
		System.out.println(bbjs);
		
		BlockBody bb2=FastJsonUtil.toBean(bbjs, BlockBody.class);
		System.out.println(bb2);
		
		BlockBody nbb=JSON.parseObject(bbjs, BlockBody.class, parserConfig);
		System.out.println(nbb);
		
		String bbgs=new Gson().toJson(blockBody);
		BlockBody bb3=new Gson().fromJson(bbgs, BlockBody.class);
		System.out.println(bb3);
	}
}
