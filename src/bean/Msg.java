package bean;

public class Msg {
	private int code;// 0成功-1失败
	private String msg;// 提示信息
	private String url;

	public Msg(int code, String msg, String url) {
		super();
		this.code = code;
		this.msg = msg;
		this.url = url;
	}

	public Msg() {
		super();
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
