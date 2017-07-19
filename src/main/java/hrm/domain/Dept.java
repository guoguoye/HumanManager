package hrm.domain;

public class Dept {
	private Integer id;//部门编号
	private String name;//部门名字
	private String description;//部门描述
	
	//鏋勯�犲櫒
	public Dept(){
		
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
		return "Dept [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	
	
	
}
