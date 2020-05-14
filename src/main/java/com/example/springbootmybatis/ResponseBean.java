package com.example.springbootmybatis;

public class ResponseBean {
	public int code ;
	public String msg ;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResponseBean() {
		super();
	}
	public ResponseBean(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
}
