package hrm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import hrm.domain.Job;
import hrm.mapper.provider.JobDynaProvider;
import hrm.mapper.provider.UserDynaProvider;

public interface JobMapper {

	//查询所有部门
	@Select("select * from job")
	List<Job> selectAllJob();
	
	//根据Id查询部门
	@Select("select * from job where id = #{id}")
	Job selectById(Integer id);
	
	//根据id删除部门
	@Delete("delete from job where id = #{id}")
	void deleteById(Integer id);
	
	//动态插入部门
	@SelectProvider(method = "insertJob", type = JobDynaProvider.class)
	void insert(Job job);
	
	//动态修改部门
	@SelectProvider(method = "updateJob", type = JobDynaProvider.class)
	void update(Job job);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = UserDynaProvider.class)
	List<Job> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = UserDynaProvider.class)
	Integer count(Map<String, Object> params);
}
