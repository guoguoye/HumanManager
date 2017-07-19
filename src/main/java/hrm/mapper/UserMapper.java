package hrm.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import hrm.domain.User;
import hrm.mapper.provider.UserDynaProvider;

public interface UserMapper {

	//根据用户名和密码查询用户
	@Select("select * from user where loginname=#{loginname} and password=#{password}")
	User selectByLoginnameAndPassword(@Param("loginname") String loginname,
			@Param("password") String password);
	
	//根据id 查询用户
	@Select("select * from user where id=#{id}")
	User selectById(Integer id);
	
	//根据id删除用户
	@Delete("delete from user where id=#{id}")
	void deleteById(Integer id);
	
	//动态修改用户
	@SelectProvider(method = "updateUser", type = UserDynaProvider.class)
	void update(User user);
	
	//动态插入用户
	@InsertProvider(method = "insertUser", type = UserDynaProvider.class)
	void inser(User user);
	
	//分页动态查询
	@SelectProvider(method = "selectWithParams", type = UserDynaProvider.class)
	List<User> selectByPage(Map<String, Object> params);
	//动态查询，当前用户数量
	@SelectProvider(method = "count", type = UserDynaProvider.class)
	Integer count(Map<String, Object> params);
	
}
