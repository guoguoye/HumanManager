package hrm.domain;

import java.util.Date;

public class User {
	private Integer id;//用户编号
	private String name;//用户姓名
	private String loginname;//用户登录名
	private String password;//用户登录密码
	private Integer state;//用户状态
	private Date createDate;//创建日期
	
	//构造器
	public User(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", loginname=" + loginname + ", password=" + password + ", state="
				+ state + ", createDate=" + createDate + "]";
	}
	
	
}
