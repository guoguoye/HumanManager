package hrm.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


public class Document {
	private Integer id;//文档编号
	private String title;//文档题目
	private String description;//文档描述
	private Date createDate;//文档创建日期
	private User user;//文档上传者
	private String filename;//文件名
	private MultipartFile file;//文件
	//构造器
	public Document(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", description=" + description + ", createDate=" + createDate
				+ ", user=" + user + ", filename=" + filename + ", file=" + file + "]";
	}
	
	
}
