package hrm.mapper.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import hrm.domain.Job;

public class JobDynaProvider {

	//动态插入
	public String insertJob(final Job job){
		return new SQL(){
			{
				INSERT_INTO("job");
				if(job.getName()!=null && !job.getName().equals("")){
					VALUES("name","#{name}");
				}
				if(job.getDescription()!=null && !job.getDescription().equals("")){
					VALUES("desciption","#{desciption}");
				}
				
			}
		}.toString();
	}
	
	//动态更新
	public String updateJob(final Job job){
		return new SQL(){
			{
				UPDATE("job");
				if(job.getName()!=null){
					SET(" name = #{name}");
				}
				if(job.getDescription()!=null){
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
					FROM("job");
					if(params.get("job")!=null){
						Job job = (Job) params.get("job");
						if(job.getName()!=null && !job.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{job.name},'%')");
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
					FROM("job");
					if(params.get("job")!=null){
						Job job = (Job) params.get("job");
						if(job.getName()!=null && !job.getName().equals("")){
							WHERE(" name LIKE CONCAT ('%',#{job.name},'%')");
						}
					}
				}
			}.toString();
		}
	
}
