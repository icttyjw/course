package edu.ictt.course.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

public class ImportInfo  extends BaseRowModel{

	@ExcelProperty(index = 0)
	private int stuid;
	@ExcelProperty(index = 1)
	private String name;
	@ExcelProperty(index = 2)
	private double score;
	public int getStuid() {
		return stuid;
	}
	public String getName() {
		return name;
	}
	public double getScore() {
		return score;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString(){
		return "id: "+stuid+
				"name: "+name+
				"score: "+score;
	}
}
