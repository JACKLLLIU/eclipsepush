package test;

import java.util.HashMap;
import java.util.Map;

public class Message {
	private int code;
	private String msg;
	private Map<String,Object> extend = new HashMap<>();
	
	public static Message success() {
		Message result = new Message();
		result.setCode(100);
		result.setMsg("ok");
		return result;
	}
	public static Message fail() {
		Message result = new Message();
		result.setCode(200);
		result.setMsg("no");
		return result;
	}
	public Message add(String key,Object value) {
		this.getExtend().put(key, value);
		return this;
	}
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
	public Map<String, Object> getExtend() {
		return extend;
	}
	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", extend=" + extend + "]";
	}
	
}
