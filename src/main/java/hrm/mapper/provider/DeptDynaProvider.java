package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Dept;

public class DeptDynaProvider {

	//动态插入
	public String insertDept(final Dept dept){
		return new SQL(){
			{
				INSERT_INTO("dept");
				if(dept.getName()!=null && !dept.getName().equals("")){
					VALUES("name","#{name}");
				}
				if(dept.getDescription()!=null && !dept.getDescription().equals("")){
					VALUES("desciption","#{desciption}");
				}
				
			}
		}.toString();
	}
	
	//动态更新
	public String updateDept(final Dept dept){
		return new SQL(){
			{
				UPDATE("dept");
				if(dept.getName()!=null){
					SET(" name = #{name}");
				}
				if(dept.getDescription()!=null){
					SET(" desciption = #{desciption}");
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
					FROM("dept");
					if(params.get("dept")!=null){
						Dept dept = (Dept) params.get("dept");
						if(dept.getName()!=null && !dept.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{dept.name},'%')");
						}
					}
				}
			}.toString();
			if(params.get("pageModel")!=null){
				sql+= " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize} ";
			}
			return sql;
		}
		
		//东南国泰查询总数量
		public String count(final Map<String, Object> params){
			return new SQL(){
				{
					SELECT("count(*)");
					FROM("dept");
					if(params.get("dept")!=null){
						Dept dept = (Dept) params.get("dept");
						if(dept.getName()!=null && !dept.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{dept.name},'%')");
						}
					}
				}
			}.toString();
		}
	
}
