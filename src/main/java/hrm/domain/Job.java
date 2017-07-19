package hrm.domain;

public class Job {
	private Integer id;//工作编号
	private String name;//岗位名称
	private String description;//岗位描述
	//构造器
	public Job(){
		
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
}
