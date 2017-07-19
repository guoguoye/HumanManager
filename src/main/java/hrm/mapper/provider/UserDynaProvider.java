package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.User;

public class UserDynaProvider {
	//动态分页查询
	public String selectWithParams(final Map<String, Object> params){
		String sql= new SQL(){
			{
				SELECT("*");
				FROM("user");
				if(params.get("user")!=null){
					User user = (User) params.get("user");
					if(user.getName()!=null && !user.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{user.name},'%')");
					}
					if(user.getState()!=null && !user.getState().equals("")){
						WHERE(" state LIKE CONCAT ('%',#{user.state},'%')");
					}
				}
			}
		}.toString();
		if(params.get("pageModel")!=null){
			sql+= " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
		}
		return sql;
	}
	
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("user");
				if(params.get("user")!=null){
					User user = (User) params.get("user");
					if(user.getName()!=null && !user.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{user.name},'%')");
					}
					if(user.getState()!=null && !user.getState().equals("")){
						WHERE(" state LIKE CONCAT ('%',#{user.state},'%')");
					}
				}
			}
		}.toString();
	}
	

	//动态修改
	public String updateUser(final User user){
		return new SQL(){
			{
				UPDATE("user");
				if(user.getName()!=null){
					SET("name = #{name}");
				}
				if(user.getLoginname()!=null){
					SET("loginname = #{loginname}");
				}
				if(user.getPassword()!=null){
					SET("password = #{password}");
				}
				if(user.getState()!=null){
					SET("state = #{state}");
				}
				if(user.getCreateDate()!=null){
					SET("createDate = #{createDate}");
				}
				WHERE("id = #{id}");
			}
		}.toString();
	}
	
	//动态插入
	public String insertUser(final User user){
		return new SQL(){
			{
				INSERT_INTO("user");
				if(user.getName()!=null && !user.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(user.getLoginname()!=null && !user.getLoginname().equals("")){
					VALUES("loginname", "#{loginname}");
				}
				if(user.getPassword()!=null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(user.getState()!=null && !user.getState().equals("")){
					VALUES("state", "#{state}");
				}
				
			}
		}.toString();
	}
}
