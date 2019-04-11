package edu.ictt.course.block;



import java.util.List;

import edu.ictt.course.block.record.DegreeRecord;
import edu.ictt.course.block.record.GradeRecord;
import edu.ictt.course.block.record.Record;

/**
 * @Author:zoe
 * @Description:
 * @Date:
 *
 */
public class BlockBody {

    //记录集合，其中第一条记录为特殊记录
    private List<GradeRecord> grecordsList;

    //这个不需要放在区块中。记录哈希值集合
    private List<DegreeRecord> drecordList;

    public BlockBody(){};

    public BlockBody(List<GradeRecord> grecordsList, List<DegreeRecord> drecordList) {
        this.grecordsList = grecordsList;
        this.drecordList = drecordList;
    }

	public List<GradeRecord> getGrecordsList() {
		return grecordsList;
	}

	public List<DegreeRecord> getDrecordList() {
		return drecordList;
	}

	public void setGrecordsList(List<GradeRecord> grecordsList) {
		this.grecordsList = grecordsList;
	}

	public void setDrecordList(List<DegreeRecord> drecordList) {
		this.drecordList = drecordList;
	}

	@Override
	public String toString() {
		return "BlockBody [grecordsList=" + grecordsList + ", drecordList=" + drecordList + "]";
	}
    

}
