package hrm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author www
 *
 */
public class Employee {

	private Integer id;//职员编号
	
	//
	private Dept dept;//职员所在部门 
	private Job job;//职员工作
	
	private String name;//职员姓名
	private String address;//职员地址
	private String email;//邮箱
	private String idCard;//身份证
	private String sex;//性别
	
	/**
	 * 
	 *
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;//生日
	private String phone;//电话号码
	private Date createDate;//创建日期
	
	//构造器
	public Employee(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", dept=" + dept + ", job=" + job + ", name=" + name + ", address=" + address
				+ ", email=" + email + ", idCard=" + idCard + ", sex=" + sex + ", birthday=" + birthday + ", phone="
				+ phone + ", createDate=" + createDate + "]";
	}

}
