package edu.ictt.course.core.controller;
public class Message {
    //0表示成功;-1表示失败
    int status;
    //向前端返回的内容
    String message;
    public Message() {
        super();
    }
    public Message(int status, String massage) {
        super();
        this.status = status;
        this.message = massage;
    }
    //get/set方法
	public int getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
}