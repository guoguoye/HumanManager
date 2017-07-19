package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Employee;

public class EmployeeDynaProvider {

	//动态插入
	public String insertEmployee(final Employee employee){
		return new SQL(){
			{
				INSERT_INTO("employee");
				if(employee.getName()!=null && !employee.getName().equals("")){
					VALUES("name","#{name}");
				}
				if(employee.getAddress()!=null && !employee.getAddress().equals("")){
					VALUES("address","#{address}");
				}
				if(employee.getEmail()!=null && !employee.getEmail().equals("")){
					VALUES("email","#{email}");
				}
				if(employee.getIdCard()!=null && employee.getIdCard()!=null){
					VALUES("idCard","#{idCard}");
				}
				if(employee.getSex()!=null && employee.getSex()!=null){
					VALUES("sex","#{sex}");
				}
				if(employee.getBirthday()!=null && employee.getBirthday()!=null){
					VALUES("birthday","#{birthday}");
				}
				if(employee.getPhone()!=null && employee.getPhone()!=null){
					VALUES("phone","#{phone}");
				}
				if(employee.getCreateDate()!=null && employee.getCreateDate()!=null){
					VALUES("createDate","#{createDate}");
				}
				
				if(employee.getDept()!=null && employee.getDept().getId()!=null){
					VALUES("deptid","#{dept.id}");
				}
				
				if(employee.getJob()!=null && employee.getJob().getId()!=null){
					VALUES("jobid","#{job.id}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String updateEmployee(final Employee employee){
		return new SQL(){
			{
				UPDATE("employee");
				if(employee.getName()!=null && !employee.getName().equals("")){
					SET(" name = #{name}");
				}
				if(employee.getAddress()!=null && !employee.getAddress().equals("")){
					SET(" address = #{address}");
				}
				if(employee.getEmail()!=null && !employee.getEmail().equals("")){
					SET(" email = #{email}");
				}
				if(employee.getIdCard()!=null && employee.getIdCard()!=null){
					SET(" idCard = #{idCard}");
				}
				if(employee.getSex()!=null && employee.getSex()!=null){
					SET(" sex = #{sex}");
				}
				if(employee.getBirthday()!=null && employee.getBirthday()!=null){
					SET(" birthday = #{birthday}");
				}
				if(employee.getPhone()!=null && employee.getPhone()!=null){
					SET(" phone = #{phone}");
				}
				if(employee.getCreateDate()!=null && employee.getCreateDate()!=null){
					SET(" createDate = #{createDate}");
				}
				
				if(employee.getDept()!=null && employee.getDept().getId()!=null){
					SET(" deptid = #{dept.id}");
				}
				
				if(employee.getJob()!=null && employee.getJob().getId()!=null){
					VALUES("jobid","#{job.id}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
	//动态分页查询
		public String selectWithParams(final Map<String, Object> params){
			String sql= new SQL(){
				{
					SELECT("*");
					FROM("employee");
					if(params.get("employee")!=null){
						Employee employee = (Employee) params.get("employee");
						if(employee.getDept()!=null && employee.getDept().getId()!=null && employee.getDept().getId()!=0){
							WHERE(" deptid = #{employee.dept.id}");
						}
						if(employee.getJob()!=null && employee.getJob().getId()!=null && employee.getDept().getId()!=0){
							WHERE(" jobid = #{employee.job.id}");
						}
						if(employee.getName()!=null && !employee.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{employee.name},'%')");
						}
						if(employee.getIdCard()!=null && !employee.getIdCard().equals("")){
							WHERE(" idCard LIKE CONCAT ('%',#{employee.idCard},'%')");
						}
						if(employee.getSex()!=null && !employee.getSex().equals("")){
							WHERE(" sex LIKE CONCAT ('%',#{employee.sex},'%')");
						}
					}
				}
			}.toString();
			if(params.get("pageModel")!=null){
				sql+= " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
			}
			return sql;
		}
		
		//动态查询总数量
		public String count(final Map<String, Object> params){
			return new SQL(){
				{
					SELECT("count(*)");
					FROM("employee");
					if(params.get("employee")!=null){
						Employee employee = (Employee) params.get("employee");
						if(employee.getDept()!=null && employee.getDept().getId()!=null && employee.getDept().getId()!=0){
							WHERE(" deptid = #{employee.dept.id}");
						}
						if(employee.getJob()!=null && employee.getJob().getId()!=null && employee.getDept().getId()!=0){
							WHERE(" jobid = #{employee.job.id}");
						}
						if(employee.getName()!=null && !employee.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{employee.name},'%')");
						}
						if(employee.getIdCard()!=null && !employee.getIdCard().equals("")){
							WHERE(" idCard LIKE CONCAT ('%',#{employee.idCard},'%')");
						}
						if(employee.getSex()!=null && !employee.getSex().equals("")){
							WHERE(" sex LIKE CONCAT ('%',#{employee.sex},'%')");
						}
					}
				}
			}.toString();
		}
	
}
