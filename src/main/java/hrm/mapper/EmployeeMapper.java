package hrm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import hrm.domain.Employee;
import hrm.mapper.provider.EmployeeDynaProvider;

public interface EmployeeMapper {

	
	//根据Id查询
	@Select("select * from employee where id = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="idCard",property="idCard"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="createDate",property="createDate",javaType=java.util.Date.class),
		@Result(column="deptid",property="dept",one=@One(select="hrm.mapper.DeptMapper.selectById",fetchType=FetchType.EAGER)),
		@Result(column="jobid",property="job",one=@One(select="hrm.mapper.JobMapper.selectById",fetchType=FetchType.EAGER))
	})
	Employee selectById(Integer id);
	
	//根据id删除
	@Delete("delete from employee where id = #{id}")
	void deleteById(Integer id);
	
	//动态插入
	@SelectProvider(method = "insertEmployee", type = EmployeeDynaProvider.class)
	void insert(Employee employee);
	
	//动态修改
	@SelectProvider(method = "updateEmployee", type = EmployeeDynaProvider.class)
	void update(Employee employee);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = EmployeeDynaProvider.class)
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="idCard",property="idCard"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="createDate",property="createDate",javaType=java.util.Date.class),
		@Result(column="deptid",property="dept",one=@One(select="hrm.mapper.DeptMapper.selectById",fetchType=FetchType.EAGER)),
		@Result(column="jobid",property="job",one=@One(select="hrm.mapper.JobMapper.selectById",fetchType=FetchType.EAGER))
	})
	List<Employee> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = EmployeeDynaProvider.class)
	Integer count(Map<String, Object> params);
}
