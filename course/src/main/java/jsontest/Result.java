package jsontest;

import com.alibaba.fastjson.annotation.JSONField;

public class Result {

    private int code;

    private String msg;

    private ResultData data;

    private static class ResultData {
    	@JSONField(deserializeUsing = PersonDeserializer.class)
        private Person personInfo;

		public Person getPersonInfo() {
			return personInfo;
		}

		public void setPersonInfo(Person personInfo) {
			this.personInfo = personInfo;
		}
    	
    }

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public ResultData getData() {
		return data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(ResultData data) {
		this.data = data;
	}
    
}