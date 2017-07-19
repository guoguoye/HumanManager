package hrm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import hrm.domain.Dept;
import hrm.mapper.provider.DeptDynaProvider;
import hrm.mapper.provider.UserDynaProvider;

public interface DeptMapper {

	//查询所有部门
	@Select("select * from dept")
	List<Dept> selectAllDept();
	
	//根据Id查询部门
	@Select("select * from dept where id = #{id}")
	Dept selectById(Integer id);
	
	//根据id删除部门
	@Delete("delete from dept where id = #{id}")
	void deleteById(Integer id);
	
	//动态插入部门
	@SelectProvider(method = "insertDept", type = DeptDynaProvider.class)
	void insert(Dept dept);
	
	//动态修改部门
	@SelectProvider(method = "updateDept", type = DeptDynaProvider.class)
	void update(Dept dept);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = UserDynaProvider.class)
	List<Dept> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = UserDynaProvider.class)
	Integer count(Map<String, Object> params);
}
